rootView.post(
        new Runnable() {
            @Override
            public void run() {
                if (MainActivity.mInterstitialAd.isLoaded()) 
                    MainActivity.mInterstitialAd.show();
            }
        }
);