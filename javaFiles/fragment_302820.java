public class MainActivity extends Activity 
     implements RadioGroup.OnCheckedChangeListener, View.OnClickListener{

EditText et1;
EditText et2;
EditText et3;
RadioButton rb1;
RadioButton rb2;
RadioButton rb3;
RadioButton rb4;
RadioGroup rg1;


@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    et1=(EditText)findViewById(R.id.billText);
    et2=(EditText)findViewById(R.id.tipText);
    et3=(EditText)findViewById(R.id.totalText);
    rb1=(RadioButton)findViewById(R.id.five);
    rb2=(RadioButton)findViewById(R.id.ten);
    rb3=(RadioButton)findViewById(R.id.fifteen);
    rb4=(RadioButton)findViewById(R.id.twenty);
    rg1=(RadioGroup)findViewById(R.id.radioGroup1);
    rg1.setOnCheckedChangeListener(this);

}
public void myClickHandler(View view)
{

    switch (view.getId())
    {
    case R.id.calcBtn:

      int i =   rg1.getCheckedRadioButtonId();
      if (i==rb1.getId()){
        double Bill = Double.parseDouble(et1.getText().toString());
        double Tip = Bill * .05;
        double Total = Tip + Bill;
        DecimalFormat df = new DecimalFormat("#.00");
        et2.setText(df.format(Tip));
        et3.setText(df.format(Total));
      }
     if (i==rb2.getId()){
        double Bill = Double.parseDouble(et1.getText().toString());
        double Tip = Bill * .1;
        double Total = Tip + Bill;
        DecimalFormat df = new DecimalFormat("#.00");
        et2.setText(df.format(Tip));
        et3.setText(df.format(Total));
    }
    if (i==rb3.getId()){
        double Bill = Double.parseDouble(et1.getText().toString());
        double Tip = Bill * .15;
        double Total = Tip + Bill;
        DecimalFormat df = new DecimalFormat("#.00");
        et2.setText(df.format(Tip));
        et3.setText(df.format(Total));
    }
    if (i==rb4.getId()){
        double Bill = Double.parseDouble(et1.getText().toString());
        double Tip = Bill * .2;
        double Total = Tip + Bill;
        DecimalFormat df = new DecimalFormat("#.00");
        et2.setText(df.format(Tip));
        et3.setText(df.format(Total));
       break;
    }
    case R.id.resetBtn:
        et1.setText("");
        et2.setText("");
        et3.setText("");
        break;
    }
}

}