public void saveStatus(String key,boolean b){
    SharedPreferences preferences = getApplicationContext().getSharedPreferences("STATUS", android.content.Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();
    editor.putBoolean(key,b);
    editor.commit();
}