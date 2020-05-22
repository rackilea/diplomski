package com.peky.smartornot;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class POV1 extends Activity {
    Sql ulaz= new Sql(this);
    int ispravka=0;
    int brojac = 0, brojac1 = 0, brojac2 = 0, joker1,joker2,joker3,joker4;
    TextView joke4text;
    TextView joke3text;
    TextView joke2text;
    TextView joke1text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pov1);
        sve();
    }
public void sve() {
        // TODO Auto-generated method stub
        int joker1,joker2,joker3,joker4;
        ulaz.open();
        joker1=ulaz.procitaj();
        joker2=ulaz.procitaj2();
        joker3=ulaz.procitaj3();
        joker4=ulaz.procitaj4();
        ulaz.close();
        TabHost joker = (TabHost) findViewById(R.id.tabhost);
        joker.setup();
        TabSpec izgled = joker.newTabSpec("tag1");
        izgled.setContent(R.id.tab1);
        izgled.setIndicator("Joker 1");
        joker.addTab(izgled);
        izgled = joker.newTabSpec("tag2");
        izgled.setContent(R.id.tab2);
        izgled.setIndicator("Joker 2");
        joker.addTab(izgled);
        izgled = joker.newTabSpec("tag3");
        izgled.setContent(R.id.tab3);
        izgled.setIndicator("Joker 3");
        joker.addTab(izgled);
        izgled = joker.newTabSpec("tag4");
        izgled.setContent(R.id.tab4);
        izgled.setIndicator("Joker 4");
        joker.addTab(izgled);
        joke1text=(TextView)findViewById(R.id.joker1text);
        joke1text.setText("You have "+ joker1 +" jokers !");
        joke2text=(TextView)findViewById(R.id.joker2text);
        joke2text.setText("You have "+ joker2 +" jokers !");
        joke3text=(TextView)findViewById(R.id.joker3text);
        joke3text.setText("You have "+ joker3 +" jokers !");
        joke4text=(TextView)findViewById(R.id.joker4text);
        joke4text.setText("You have "+ joker4 +" jokers !");
    }
    public void joker4(View view) {
        Button netocan = (Button) findViewById(R.id.button5);
        Button netocan2 = (Button) findViewById(R.id.button4);
        Button netocan3 = (Button) findViewById(R.id.button2);
        if(joker4!=0){
        netocan.setVisibility(View.INVISIBLE);
        netocan2.setVisibility(View.INVISIBLE);
        netocan3.setVisibility(View.INVISIBLE);
        joker4=joker4-1;
        }else{Toast joker1=Toast.makeText(getApplicationContext(), "Not enought JOKERS4", Toast.LENGTH_LONG);
        joker1.show();

        }
@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pov1, menu);
        return false;
    }