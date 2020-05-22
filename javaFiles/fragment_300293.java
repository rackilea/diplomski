package com.example.app;


//import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
//import android.widget.DatePicker;

import android.widget.TextView;

public class Second extends Activity implements OnClickListener {
    CheckBox Facebook_chk;
    TextView Facebook_name;
    TextView Name;
    TextView Id;
    TextView Txterr;
    TextView Pass;
    Button Btn1;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.second);
        Btn1 = (Button) findViewById(R.id.Btn1);
        Facebook_chk = (CheckBox)findViewById(R.id.Cfbook);//Represents the facebook checkbox.
        Facebook_name = (TextView)findViewById(R.id.Face);//represents the facebook text.
        Name = (TextView)findViewById(R.id.Name);//represents the Name text.
        Id = (TextView)findViewById(R.id.Id);//represents the Id text.
        Txterr = (TextView)findViewById(R.id.Txterr);//represents the Id text.
        Pass = (TextView)findViewById(R.id.Pass);//represents the Pass text.


        Btn1.setOnClickListener(this);
        Facebook_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if(Facebook_chk.isChecked())
                    Facebook_name.setEnabled(true);
                else
                    Facebook_name.setEnabled(false);
                ;
            }
        });

    }


    public String GetErr(){

        String error="";
        if(Facebook_name==null && Facebook_chk.isChecked())//check with title if not available.
        {
            error+="facebook account not entered/n";//also check if not available
        }
        if(Name==null)
            error+="Name not entered/n";
        if(Id.toString().contains("[a-zA-Z]+") || Id==null)
            error+="Id entered is invalid/n";
        if(Pass.toString().length()<5)
            error+="Passwords must contain 5 or more digits";
        //  int day= Date.getDayOfMonth();
        //  int month = Date.getMonth();
        //  int year=Date.getYear();
        //Calendar enter = Calendar.getInstance();
        //  Calendar today = Calendar.getInstance();
        //  enter.set(year,month,day);
        //  today.set(Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH);
        //if((enter.getTime().before(today.getTime())))
        //  error+="Date entered either passed or not available.";

        return error;
    }
    @Override
    public void onClick(View v) {
        if(v == Btn1){
            String err = GetErr();
            if(err != ""){
                Txterr.setText(err);
            }
        }
    }

}