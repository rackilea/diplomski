package com.example.surya.musicpleer;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {

    ImageView i1;
    Random r = new Random();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i1 = (ImageView) findViewById(R.id.imageView);
        i1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int target = r.nextInt(3);
                String drawablename = "photo" + target;

                int resID = getResources().getIdentifier(drawablename, "drawable", getPackageName());

                i1.setImageResource(resID);
            }
        });
    }
}