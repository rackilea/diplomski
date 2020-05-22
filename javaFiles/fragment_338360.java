...
    SharedPreferences.Editor editor = sh.edit();
    editor.putString(SharedPrefManager.RESTAURANT_LAT, String.valueOf(latitude));
    editor.putString(SharedPrefManager.RESTAURANT_LON, String.valueOf(longitude));
    Log.d("ResultRestroSave", String.valueOf(editor));

    Log.d("ResultRestrodata", latitude + longitude);
    editor.commit();

    ...