@Override
protected void onResume() {
    SharedPreferences prefs = getSharedPreferences("settings_prefs", Context.MODE_PRIVATE);
    boolean switchState1 = prefs.getBoolean("switch1_state", false);
    // Do more stuff
}