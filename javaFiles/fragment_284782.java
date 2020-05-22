public void onClick(View v) {
//handle user clicks here
EditText enteredText = (EditText) findViewById(R.id.enter);
String words = enteredText.getText().toString();
speakWords(words);

 }