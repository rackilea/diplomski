package com.elitiv.myapplication2.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {


private EditText Result;
private Double NumberYear;
private Double NumberCapacity;
private String Operation;
private Double NumberResult;
private EditText editYear;
private EditText editCapacity;
private Button calc;
private RadioButton radioD;
private RadioButton radioB;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView Year = (TextView)findViewById(R.id.Year);
    TextView Capacity = (TextView)findViewById(R.id.Capacity);
    editYear = (EditText)findViewById(R.id.editYear);
     editCapacity = (EditText)findViewById(R.id.editCapacity);
    final EditText Result = (EditText)findViewById(R.id.Result);
    Button   calc =(Button)findViewById(R.id.calc);
    final RadioButton radioD = (RadioButton)findViewById(R.id.radioD);
    final RadioButton radioB = (RadioButton)findViewById(R.id.radioB);
calc.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
int edityear_value=Integer.parseInt(editYear.getText().toString());//Convert to intger
    if(radioB.isChecked()){
        switch (edityear_value){

            case 2004:
                Operation=("2004");
                break;
            case 2005:
                Operation="2005";
                break;
            case 2006:
                Operation="2006";
                break;
            case 2007:
                Operation="2007";
                break;
            case 2008:
                Operation="2007";
                break;
            case 2009:
                Operation="2009";
                break;
            case 2010:
                Operation="2010";
                break;
            case 2011:
                Operation="2011";
                break;
            case 2012:
                Operation="2011";
                break;
            case 2013:
                Operation="2013";
                break;
            case 2014:
                Operation="2013";
                break;
        }

    }
    else
        if(radioD.isChecked()){
            switch(edityear_value){

                case 2004:
                    Operation="20041";
                    break;
                case 2005:
                    Operation="20051";
                    break;
                case 2006:
                    Operation="20061";
                    break;
                case 2007:
                    Operation="20071";
                    break;
                case 2008:
                    Operation="20071";
                    break;
                case 2009:
                    Operation="20091";
                    break;
                case 2010:
                    Operation="20101";
                    break;
                case 2011:
                    Operation="20111";
                    break;
                case 2012:
                    Operation="20111";
                    break;
                case 2013:
                    Operation="20131";
                    break;
                case 2014:
                    Operation="20131";
                    break;
            }

}
Operation();//when click tht button, set the values and call function to calculate over these values
}
}


);


}



public void Operation(){

Double result;
//Benzin
if(NumberCapacity >0 &&NumberCapacity <1000) {
    if (Operation.equals(2004)) {
        result = NumberCapacity * 0.52;

    }
    if (Operation.equals("2005")) {
        result = NumberCapacity * 0.50;

    }
    if (Operation.equals("2006")) {
        result = NumberCapacity * 0.47;

    }
    if (Operation.equals("2007")) {
        result = NumberCapacity * 0.44;
    }
    if (Operation.equals("2009")) {
        result = NumberCapacity * 0.43;

    }
    if (Operation.equals("2011")) {
        result = NumberCapacity * 0.42;

    }

    if (Operation.equals("2013")) {
        result = NumberCapacity * 0.40;

    }
   }
if(NumberCapacity >1001 &&NumberCapacity <1500){
    if (Operation.equals("2004")) {
        result = NumberCapacity * 0.67;

    }
    if (Operation.equals("2005")) {
        result = NumberCapacity * 0.63;
    }
    if (Operation.equals("2006")) {
        result = NumberCapacity * 0.60;
    }
    if (Operation.equals("2007")) {
        result = NumberCapacity * 0.56;
    }
    if (Operation.equals("2009")) {
        result = NumberCapacity * 0.55;
    }
    if (Operation.equals("2011")) {
        result = NumberCapacity * 0.54;
    }
    if (Operation.equals("2013")) {
        result = NumberCapacity * 0.52;
    }
}
if(NumberCapacity >1501 &&NumberCapacity <2000){
    if (Operation.equals("2004")) {
        result = NumberCapacity * 1.00;
    }
    if (Operation.equals("2005")) {
        result = NumberCapacity * 0.95;
    }
    if (Operation.equals("2006")) {
        result = NumberCapacity * 0.89;
    }
    if (Operation.equals("2007")) {
        result = NumberCapacity * 0.84;
    }
    if (Operation.equals("2009")) {
        result = NumberCapacity * 0.83;
    }
    if (Operation.equals("2011")) {
        result = NumberCapacity * 0.82;
    }
    if (Operation.equals("2013")) {
        result = NumberCapacity * 0.80;
    }
}
if(NumberCapacity >2001 &&NumberCapacity <3000){
    if (Operation.equals("2004")) {
        result = NumberCapacity * 1.59;
    }
    if (Operation.equals("2005")) {
        result = NumberCapacity * 1.52;
    }
    if (Operation.equals("2006")) {
        result = NumberCapacity * 1.44;
    }
    if (Operation.equals("2007")) {
        result = NumberCapacity * 1.36;
    }
    if (Operation.equals("2009")) {
        result = NumberCapacity * 1.35;
    }
    if (Operation.equals("2011")) {
        result = NumberCapacity * 1.34;
    }
    if (Operation.equals("2013")) {
        result = NumberCapacity * 1.32;
    }
}
if(NumberCapacity >3000 ){
    if (Operation.equals("2004")) {
        result = NumberCapacity * 3.57;
    }
    if (Operation.equals("2005")) {
        result = NumberCapacity * 3.56;
    }
    if (Operation.equals("2006")) {
        result = NumberCapacity * 3.55;
    }
    if (Operation.equals("2007")) {
        result = NumberCapacity * 3.54;
    }
    if (Operation.equals("2009")) {
        result = NumberCapacity * 3.53;
    }
    if (Operation.equals("2011")) {
        result = NumberCapacity * 3.52;
    }
    if (Operation.equals("2013")) {
        result = NumberCapacity * 3.50;
    }
}

//Diesel
if(NumberCapacity <1500){
    if (Operation.equals("20041")) {
        result = NumberCapacity * 1.67;
    }
    if (Operation.equals("20051")) {
        result = NumberCapacity * 1.63;
    }
    if (Operation.equals("20061")) {
        result = NumberCapacity * 1.60;
    }
    if (Operation.equals("20071")) {
        result = NumberCapacity * 1.56;
    }
    if (Operation.equals("20091")) {
        result = NumberCapacity * 1.55;
    }
    if (Operation.equals("20111")) {
        result = NumberCapacity * 1.54;
    }
    if (Operation.equals("20131")) {
        result = NumberCapacity * 1.52;
    }
}
if(NumberCapacity >1501 &&NumberCapacity <2500){
    if (Operation.equals("20041")) {
        result = NumberCapacity * 1.59;
    }
    if (Operation.equals("20051")) {
        result = NumberCapacity * 1.52;
    }
    if (Operation.equals("20061")) {
        result = NumberCapacity * 1.44;
    }
    if (Operation.equals("20071")) {
        result = NumberCapacity * 1.36;
    }
    if (Operation.equals("20091")) {
        result = NumberCapacity * 1.35;
    }
    if (Operation.equals("20111")) {
        result = NumberCapacity * 1.34;
    }
    if (Operation.equals("20131")) {
        result = NumberCapacity * 1.32;
    }
}
if(NumberCapacity >2501 ){
    if (Operation.equals("20041")) {
        result = NumberCapacity * 3.57;
    }
    if (Operation.equals("20051")) {
        result = NumberCapacity * 3.56;
    }
    if (Operation.equals("20061")) {
        result = NumberCapacity * 3.55;
    }
    if (Operation.equals("20071")) {
        result = NumberCapacity * 3.54;
    }
    if (Operation.equals("20091")) {
        result = NumberCapacity * 3.53;
    }
    if (Operation.equals("20111")) {
        result = NumberCapacity * 3.52;
    }
    if (Operation.equals("20131")) {
        result = NumberCapacity * 3.50;

    }

}
        Result.setText(String.valueOf(result));//Set the value after calculate it
}
}