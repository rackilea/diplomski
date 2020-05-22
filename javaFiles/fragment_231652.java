if (!currentHomePackage.equals(customlauncherpackage)) {
    boolean bChooserShown;
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
    bChooserShown = sharedPreferences.getBoolean(getString(R.string.setup_flag_active), false);

    if (bChooserShown) {
        //Display a dialog to the user indicating that they selected the wrong launcher before and will have to reset the launcher from settings.
        ... dialog here ...
        //Then redirect to settings
        if (Build.VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
            Intent i = new Intent(Settings.ACTION_HOME_SETTINGS, null);
            startActivityForResult(i, REQUEST_LAUNCH_HOME_SETTINGS);
        } else {
            Intent i = new Intent(Settings.ACTION_SETTINGS, null);
            startActivityForResult(i, REQUEST_LAUNCH_HOME_SETTINGS);
        }
   }
   else {
       //do chooser process
   }