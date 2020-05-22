public void onClick(View v) {
//handle user clicks here
TextView myword = (TextView) findViewById(R.id.myword);
String words = myword.getText().toString();
speakWords(words);

}