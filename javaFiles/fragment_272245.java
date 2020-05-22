final String TAG = "some final text";
sharedPref = new SharedPreferences();
sharedPref = getSharedPreferences(TAG,Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();

    editor.putString("key","your_string");
    editor.apply();