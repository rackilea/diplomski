@Override
public void onResume() {
super.onResume();
String value = PreferenceManager.getDefaultSharedPreferences(getContext())
        .getString(key, "");
if (value != null && !value.isEmpty()) {
    Categories.setText(value);
  PreferenceManager.getDefaultSharedPreferences(getContext()).edit().remove(key);
   }
}