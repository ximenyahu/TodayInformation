package com.simon.todayinformation;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "SplashActivity";
    private FullScreenVideoView mVideoSplash;
    private TextView mTvCountDown;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mVideoSplash = findViewById(R.id.video_splash);
        mTvCountDown = findViewById(R.id.tv_count_down);
        Uri splashUri = Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash);
        mVideoSplash.setVideoURI(splashUri);
        mVideoSplash.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });

        mVideoSplash.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });

        /*
        这里是第一种方法
        CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {
                mTvCountDown.setText("剩余" + l / 1000 + "秒");
            }

            @Override
            public void onFinish() {
                mTvCountDown.setText("点击跳过");
            }
        };
        countDownTimer.start();
        */

    }
}
