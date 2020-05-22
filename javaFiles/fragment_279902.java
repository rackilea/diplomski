public void createLoginSession(String name){
     editor = pref.edit();
    editor.putBoolean(IS_LOGIN, true);
   editor.putString(KEY_NAME, name);
    // commit change
    editor.commit(); // replace commit with apply
    Log.i("Editor",""+IS_LOGIN);
}