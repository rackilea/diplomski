package com.cris96.rssreader;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class RssReader extends Activity {
    private Button button1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rss_reader);

        button1 = (Button) findViewById(R.id.b1);
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                System.out.println("test");

            }
        });

    }

}