SharedPreferences preferences = this.getSharedPreferences("com.example.jackson.distressalarm", Context.MODE_PRIVATE);
SharedPreferences.Editor editor = preferences.edit();

editor.putString("callNumber", NumberToCall.getText().toString());
editor.putString("1Text", text1.getText().toString());
editor.putString("2Text", text2.getText().toString());
editor.putString("3Text", text3.getText().toString());

editor.apply();