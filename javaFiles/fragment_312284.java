CheckBox chkqONEans1;
CheckBox chkqTWOans2;
CheckBox chkqTHREEans3;
Button btnScore;
String stringqONEans1,stringqTWO1ans2,stringqTHREE1ans3,master;
EditText etResult;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    chkqONEans1 = (CheckBox)findViewById(R.id.chkqONEans1);
    chkqTWOans2 = (CheckBox)findViewById(R.id.chkqTWOans2);
    chkqTHREEans3= (CheckBox)findViewById(R.id.chkqTHREEans3);
    btnScore = (Button)findViewById(R.id.btnScore);
    etResult = (EditText)findViewById(R.id.etResult);
}

public void onScore(View view){
    if( chkqONEans1.isChecked()){
        stringqONEans1 = "Correct Ans Canton";
        chkqONEans1.setEnabled(false);
    }
    if(chkqTWOans2.isChecked()){
        stringqTWO1ans2 = "Correct Ans Akron";
        chkqTWOans2.setEnabled(false);
    }
    if( chkqTHREEans3.isChecked()){
        stringqTHREE1ans3 = "INCORRECT Ans Duluth";
        chkqTHREEans3.setEnabled(false);
    }
    //if (chkqONEans1.isChecked() &&  chkqTWOans2.isChecked() && chkqTHREEans3.isChecked()){
        //Toast.makeText(MainActivity.this, "Only Two Answers", Toast.LENGTH_LONG).show();
        //return;
    //}

    if( chkqONEans1.isEnabled()== false && chkqTWOans2.isEnabled()==false &&  chkqTHREEans3.isEnabled()==true){
        Toast.makeText(MainActivity.this, "Go On You Have Two Answers 1 & 2", Toast.LENGTH_LONG).show();
        master = "  " + stringqONEans1 +"\n  "+stringqTWO1ans2;
        showAns();

    }else if ( chkqONEans1.isEnabled()== false && chkqTWOans2.isEnabled()==true &&  chkqTHREEans3.isEnabled()==false){
        Toast.makeText(MainActivity.this, "Go On You Have Two Answers 1 & 3", Toast.LENGTH_LONG).show();
        master = stringqONEans1 +"  "+stringqTHREE1ans3;
        showAns();

    }else if ( chkqONEans1.isEnabled()== true && chkqTWOans2.isEnabled()==false &&  chkqTHREEans3.isEnabled()==false){
        Toast.makeText(MainActivity.this, "Go On You Have Two Answers 2 & 3", Toast.LENGTH_LONG).show();
       master = stringqTWO1ans2 +"  "+stringqTHREE1ans3;
        showAns();

    }else if( chkqONEans1.isEnabled()== false &&chkqTWOans2.isEnabled()== false && chkqTHREEans3.isEnabled()== false){
        Toast.makeText(MainActivity.this, "ONLY TWO Answers ", Toast.LENGTH_LONG).show();
        chkqONEans1.setEnabled(true);
        chkqONEans1.setChecked(false);
        chkqTWOans2.setEnabled(true);
        chkqTWOans2.setChecked(false);
        chkqTHREEans3.setEnabled(true);
        chkqTHREEans3.setChecked(false);
        return;
    }
}

public void showAns(){
    etResult.setText(master);
}