package com.andro.coundowntimer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String htmlCode= "<h2>Hey !</h2>\n" +
                "<blockquote>\n" +
            "<p><span style=\"color: #0000ff;\">hello world <em><strong>is a virtual world.</strong></em></span>\uD83D\uDE02</p>\n" +
            "</blockquote>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView=findViewById(R.id.textView);
        textView.setText(HtmlCompat.fromHtml(htmlCode,0)); 
    }
}