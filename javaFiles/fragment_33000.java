package com.example.seekbartest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;

public class SeekbarTest extends Activity {
/** Called when the activity is first created. */
private SeekBar seekBar;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    seekBar = (SeekBar)findViewById(R.id.seekBar1);

    Button fortyPctButton = (Button)findViewById(R.id.buttonFortyPct);
    fortyPctButton.setOnClickListener(new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            seekBar.setProgress(40);
        }
    });

    Button sixtyPctButton = (Button)findViewById(R.id.buttonSixtyPct);
    sixtyPctButton.setOnClickListener(new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            seekBar.setProgress(60);
        }
    });

    Button eightyPctButton = (Button)findViewById(R.id.buttonEightyPct);
    eightyPctButton.setOnClickListener(new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            seekBar.setProgress(80);
        }
    });
    }
}