if (mInterstitialAd.isLoaded()) {

            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
        startActivity(intent);