String MyString = editText.getText().toString();

Intent intent = new Intent(this, MainActivity.class);
   Bundle bundle = new Bundle();
 bundle.putString("MyValue", MyString);  //MyValue name is your referrence name
 intent.putExtras(bundle);
  startActivity(intent);