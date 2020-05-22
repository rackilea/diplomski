protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
     /**
      Persistent Checkable Menu Start
      **/
     SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
     string = settings.getString("preference", string);
     //Log.e("User Subscription", string);
     /**
      Persistent Checkable Menu End
      **/}
@Override
public boolean onPrepareOptionsMenu(Menu menu) {
    super.onPrepareOptionsMenu(menu);
    SharedPreferences settings = this.getSharedPreferences(PREFS_NAME, 0);
    string = settings.getString("preference", string);
    if (string.equals("Vibrate")) {
        menu.findItem(R.id.start_action).setChecked(true);
        Log.e("Vibrate", string);
    }
    else if (string.equals("Disable")){
        menu.findItem(R.id.my_cancel_action).setChecked(true);
        Log.e("Disable", string);
    }
    return true;
}
// Menu options to set and cancel the alarm.
@Override
public boolean onOptionsItemSelected(MenuItem item) {
    /*persistent checkable item logic start*/
    SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
    editor = settings.edit();
    string = settings.getString("preference", string);
     /*persistent checkable item logic end*/
    int id = item.getItemId();
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    switch (id) {

        // When the user clicks START ALARM, set the alarm.
        case R.id.start_action:
            alarm.setAlarm();
            item.setChecked(true);
            string= "Vibrate";
            editor.putString("preference", string);
            editor.commit();
            // invalidateOptionsMenu();
            return true;
        // When the user clicks CANCEL ALARM, cancel the alarm.
        case R.id.my_cancel_action:
            alarm.cancelAlarm(this, 1);
            item.setChecked(true);
            string="Disable";
            editor.putString("preference", "Disable");
            editor.commit();
            //invalidateOptionsMenu();
            return true;
    }
    return super.onOptionsItemSelected(item);
}