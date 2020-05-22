private void SavePreferences(String key, String value){

        SharedPreferences sharedPreferences = getPreferences("my_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
       }