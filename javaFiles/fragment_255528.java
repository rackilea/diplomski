@Override
protected void onResume() {
    super.onResume();
    if (SettingsManager.getBoolean(this, SettingsManager.FIRST_LAUNCH, true)){
        SettingsManager.saveBoolean(this, SettingsManager.FIRST_LAUNCH, false);
        //your first launch code
    }
}