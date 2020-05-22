@Override
protected void onStop() {
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putInt("level",newlevel);
    editor.commit();
    super.onStop();
}