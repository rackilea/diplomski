package com.example.stopwatchmulti;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class Main2Activity extends AppCompatActivity {

    //Define Variables and Arrays

    String ergebnis;
    int anzahl;

    ArrayList<String> userNummern = new ArrayList<String>();
    ArrayList<String> userNamen = new ArrayList<String>();
    ArrayList<String> userZeiten = new ArrayList<String>();

    //Create Arrays without giving them a value instantly

    String[] userNr;
    String[] userName;
    String[] userZeit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ergebnis = getIntent().getExtras().getString("Ergebnis");

        anzahl = Integer.parseInt(ergebnis);

        // Add Lines in favour of UserChoice in First activity

        for(int i = 1; i < anzahl + 1; i++) {

            userNummern.add(String.valueOf(i));
            userNamen.add("User"+String.valueOf(i));
            userZeiten.add("00:00:00");
        }

        // Define Values in the Array by transforming Arrailist elements to the arrays

        userNr = userNummern.toArray(new String[0]);
        userName = userNamen.toArray(new String[0]);
        userZeit = userZeiten.toArray(new String[0]);

        // Run Custom ArrayAdapter

        ListView customListview = (ListView) findViewById(R.id.customListview);
        CustomListview customListview1 = new CustomListview(this,userNr,userName,userZeit);
        customListview.setAdapter(customListview1);

    }
}