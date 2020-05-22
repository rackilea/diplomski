@Override
public void onClick(View v) {
    EditText firstnum = (EditText) findViewById(R.id.numberinput);
    TextView resultTextView = (TextView) findViewById(R.id.resulttextview);

    // Add a null check here for safety
    if(firstnum.getText().toString() == null) return;

    int num1 = Integer.parseInt(firstnum.getText().toString()) ;
    int result = num1 * num1;
    resultTextView.setText(result + "");
}