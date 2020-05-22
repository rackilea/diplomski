public void onSavePhoto() {
    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
    long lastSaveTime = settings.getLong("last_save", 0);
    int lastDay = new DateTime(lastSaveTime).getDayOfYear();
    int today = DateTime.now().getDayOfYear();

    if (lastDay < today) {
        //add score
        addScore();
        //update preference value
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong("last_save", today);
    }
}