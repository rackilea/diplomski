public void add(View view){
    EditText editText1 = (EditText) findViewById(R.id.editText);
    EditText editText2 = (EditText) findViewById(R.id.editText2);
    EditText editText3 = (EditText) findViewById(R.id.editText3);

    int firstNumber = Integer.valueOf(editText1.getText().toString());
    int secondNumber = Integer.valueOf(editText2.getText().toString());

    int sum = 0;
    for(int i = firstNumber; i <= secondNumber; i++)
    {
        sum+=i;
    }

    editText3.setText("" + sum);
}