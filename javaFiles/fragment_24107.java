package com.android.wowowowo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler h = new Handler() ;
        h.postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }

        }, 3000);
    }
}