if(Build.VERSION.SDK_INT > 8) {
        showAdsBanner();
        mHandler.postDelayed(new Runnable() {
            public void run() {
                showAdsInterstitial();
            }
        }, 2500);
    }