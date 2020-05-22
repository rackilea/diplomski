package com.example.slick.thegiftoffailure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EditorActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_editor);

        // the quote label
        randomFailureQuotes quote = new randomFailureQuotes();
        String Fq = quote.getQuote();

        // You must retrieve the textview from your 
        // activity_layout.xml file
        TextView quoteDisplay = (TextView) findViewById(R.id.text_view);
        quoteDisplay.setText(Fq);
    }
}