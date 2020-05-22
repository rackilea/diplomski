@Override
protected void onResume() {
    super.onResume();
    if (SettingsManager.getFirstLaunch(this)){
        SettingsManager.saveFirstLaunch(this, false);
        //your first launch code
    }
}