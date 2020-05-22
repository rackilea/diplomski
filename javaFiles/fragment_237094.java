EditText firstNumber;
EditText secondNumber;
TextView addResult;
Button btnAdd;

double num1,num2,sum;

firstNumber = (EditText)findViewById(R.id.txtNumber1);
secondNumber = (EditText)findViewById(R.id.txtNumber2);
addResult = (TextView)findViewById(R.id.txtResult);
btnAdd = (Button)findViewById(R.id.btnAdd);

btnAdd.setOnClickListener(new OnClickListener() {

    public void onClick(View v) {
        num1 = Double.parseDouble(firstNumber.getText().toString());
        num2 = Double.parseDouble(secondNumber.getText().toString());
        sum = num1 + num2;
        addResult.setText(Double.toString(sum));
    }
});