String width = widthtextView.getText().toString();
String height = heightTextView.getText().toString();
...
//save the values in sharedPrefferences - the name could be what you want
SharedPreferences.Editor editor = getSharedPreferences("MyPrefsName", MODE_PRIVATE).edit();
editor.putInt("width", width);
editor.putInt("height", height);
editor.commit();