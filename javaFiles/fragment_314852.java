Boolean shouldBeep = true;


  //inside the mute/unmute button listener(or whatever)

  SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
  SharedPreferences.Editor editor = settings.edit();
  editor.putBoolean("shouldBeep", shouldBeep);

  editor.commit();