private void writeSetupFlag(boolean bInSetup) {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putBoolean(getString(R.string.setup_flag_active), bInSetup);
    editor.commit();
}