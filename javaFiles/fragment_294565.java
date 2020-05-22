protected void onResume() {
    SharedPreferences.Editor edit =  PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext()).edit();
    edit.putString("LastActiveActivity", this.getClass().getName());
    edit.commit();
    super.onResume();
}