private void loadSavedPreferences(){
    prefs = getSharedPreferences(DRINK_DATA, MODE_PRIVATE);
    String dataDrinkReturned = prefs.getString("DrinkData", DEFAULT);
    String dataShotReturned = prefs.getString("ShotData", DEFAULT);
    counterDrink = Integer.parseInt(dataDrinkReturned);
    counterShot = Integer.parseInt(dataShotReturned );
    textDrink.setText(dataDrinkReturned);
    textShot.setText(dataShotReturned);
}