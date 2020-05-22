package com.test.test200;

import java.util.Random;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

public class Test extends Activity {
/** Called when the activity is first created. */

    private String[] myString;
    private static final Random rgenerator = new Random();

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);


    Resources res = getResources();

    myString = res.getStringArray(R.array.myArray); 

    String q = myString[rgenerator.nextInt(myString.length)];

    TextView txt = (TextView) findViewById(R.id.text1);
    txt.setText(q);
}
}