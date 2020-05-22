@Override
public void onResume() {
    super.onResume();
    String value = PreferenceManager.getDefaultSharedPreferences(getContext())
            .getString(key, "");
    if (value != null && !value.isEmpty()) {
        //You have selected item value update TextView
    }
}