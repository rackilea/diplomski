Intent intent = new Intent(this, DisplayMessageActivity.class);
EditText editText = (EditText) findViewById(R.id.edit_message);
String message = editText.getText().toString();        
intent.putExtra(EXTRA_MESSAGE, message);
intent.putExtra(EXTRA_COLOR_CHOICE, colorChoice);
startActivity(intent);