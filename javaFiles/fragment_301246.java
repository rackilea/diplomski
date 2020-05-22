private void goToNextLevel() {
    // Show the next level and reload the ad to prepare for the level after.
    mLevelTextView.setText("Level " + (++mLevel));
    mInterstitialAd = newInterstitialAd();
    loadInterstitial();
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
     if (checkSelfPermission(Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
        requestPermissions(new String[]{
                Manifest.permission.INTERNET
        }, 10);

     }
    }
    new BackgroundTask().execute();

}