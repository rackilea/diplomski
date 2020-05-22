@Override
  protected void onResume() {
     SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
     int lastTimeStarted = settings.getInt("last_time_started", -1);
     Calendar calendar = Calendar.getInstance();
     int today = calendar.get(Calendar.DAY_OF_YEAR);

    if (today != lastTimeStarted) {
      //startSomethingOnce();

      SharedPreferences.Editor editor = settings.edit();
      editor.putInt("last_time_started", today);
      editor.commit();
    }
  }