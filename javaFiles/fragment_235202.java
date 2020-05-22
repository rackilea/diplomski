SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
Boolean expired= sharedPref.getBoolean("expired", false);

if (expired){
    throw new RuntimeException("Custom crash");
}

//Make it expierd
SharedPreferences pref=PreferenceManager.getDefaultSharedPreferences(this);
SharedPreferences.Editor editor = pref.edit();
editor.putBoolean("expired", true);
editor.commit();