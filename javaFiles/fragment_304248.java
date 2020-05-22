public void sumNumbers(View v){
        EditText input1 = (EditText) findViewById(R.id.input1);
        int calc1 =  Integer.parseInt(String.valueOf(input1.getText()));
        EditText input2 = (EditText) findViewById(R.id.input2);
        int calc2 = Integer.parseInt(String.valueOf(input2.getText()));
        int total = calc1 + calc2;
        String result = String.valueOf(total);
        EditText output1 = (EditText)findViewById(R.id.output);
        output1.setText(result);
    }