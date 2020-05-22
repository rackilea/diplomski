}
@Override
public void onResume() {
    super.onResume();
    SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
    string = settings.getString("preference", string);
}

@Override
protected void onStart() {
    super.onStart();
    SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
    string = settings.getString("preference", string);
}

@Override
protected void onRestart() {
    super.onRestart();
    SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
    string = settings.getString("preference", string);
}


@Override
protected void onPause() {
    super.onPause();
    SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
    string = settings.getString("preference", string);
}
@Override
protected void onStop() {
    super.onStop();
    SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
    string = settings.getString("preference", string);
}