SharedPreferences pref = getSharedPreferences(Constants.ApplicationTag, Activity.MODE_PRIVATE);

if (!pref.contains(Constants.FIRST_LAUNCH)) {
    addUser();
    pref.edit().putBoolean(Constants.FIRST_LAUNCH, true).commit();
}