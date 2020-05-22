@Override
protected void onPreExecute() {
    super.onPreExecute();
    //get sharedPreferences here
    SharedPreferences sharedPreferences = getSharedPreferences(<SharedPreferencesName>, <Mode>);
}