public void SaveInt(String key, int value){
    SharedPreferences sharedPreferences = getSharedPreferences("points", Activity.MODE_PRIVATE)
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putInt(key, value);
    editor.commit();
}