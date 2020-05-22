@Override
public void onResume() {
    super.onResume();
    Preference search = findPreference(getString(R.string.setting_edit_text_key));
    search.performClick();
}