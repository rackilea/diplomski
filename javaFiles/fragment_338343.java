public static isAdLoadedOnce = false;
    ----------------------------------------------

    mInterstitialAd = new InterstitialAd(this);
    mInterstitialAd.setAdUnitId(getString(R.string.interstitial_id));
    mInterstitialAd.loadAd(new AdRequest.Builder().build());
    mInterstitialAd.setAdListener(new AdListener() {
        @Override
        public void onAdLoaded() {

                if (!isAdLoadedOnce & mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    isAdloadedOnce = true;
                }
                    else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });