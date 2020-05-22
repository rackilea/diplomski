public void grade (View view){
  final EditText varEditBox = (EditText)findViewById(R.id.editBox);
  TextView varText = (TextView) findViewById(R.id.textView);
  Button button = (Button) findViewById(R.id.button);
  // trim to remove whitespace
  final String text = varEditBox.getText().toString().trim();

  if (TextUtils.isEmpty(text) || !TextUtils.isDigitsOnly(text)){
    Toast.makeText(getApplicationContext(), "EMPTY OR NOT NUMERIC", Toast.LENGTH_SHORT).show();
    varText.setText("");
    // quit early, don't need to parse this number
    return;
  }

  // we should have already quit by now if we can't parse this number
  int value = Integer.parseInt(text);

  if (value >= 101 || value < 1) {
    Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
    varText.setText("");
  }
}