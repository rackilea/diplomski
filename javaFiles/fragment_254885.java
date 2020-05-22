runOnUiThread(new Runnable()
    {
        @Override
        public void run()
        {
            AdRequest aRequest;
            aRequest = new AdRequest.Builder().build();
            mInterstitialAd.loadAd(aRequest);
        }
    });