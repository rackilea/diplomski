private void loadSavedPreferences(){
    prefs = getSharedPreferences(DRINK_DATA, MODE_PRIVATE);
    counterDrink  = prefs.getInt("DrinkData", 0);
    counterShot = prefs.getInt("ShotData", 0);
    textDrink.setText(""+counterDrink);
    textShot.setText(""+counterShot);
}

@Override
protected void onPause(){
    super.onPause();
    prefs = getSharedPreferences(DRINK_DATA, MODE_PRIVATE);
    editor.putInt("DrinkData", counterDrink );
    editor.putInt("ShotData", counterShot );
    editor.commit();
}