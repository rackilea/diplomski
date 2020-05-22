EditText editText = (EditText) findViewById(R.id.editText);
TextView textView = (TextView) findViewById(R.id.textView);
Button button = (Button) findViewById(R.id.button);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        try{
            String string = editText.getText().toString();
            int num = Integer.parseInt(string); // retrieve the updated value
            String number = String.valueOf(num);
            textView.setText(number);
        }
        catch(NumberFormatException numb){
            Toast.makeText(this, "Problem", Toast.LENGTH_SHORT).show();
        }
    }
});