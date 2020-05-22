SharedPreferences prefs = getSharedPreferences(mypreference, MODE_PRIVATE);
 String ap = prefs.getString("mn","");
 text.setText(ap);
 button.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View view) {

        SharedPreferences shared = getSharedPreferences(mypreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString("mn",editText.getText().toString());
        editor.commit();

        SharedPreferences prefs = getSharedPreferences(mypreference, MODE_PRIVATE);
        String ap = prefs.getString("mn","");
        text.setText(ap);

    }

});