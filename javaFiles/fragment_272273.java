calcButton = (Button)findViewById(R.id.button1);
calcButton.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View view) {
        number1 = (EditText) findViewById(R.id.edtext1);
        number2 = (EditText) findViewById(R.id.edtext2);
        double num1 = Double.parseDouble(number1.getText().toString());
        double num2 = Double.parseDouble(number2.getText().toString());
        calcRectangle(num1, num2);
    }
});