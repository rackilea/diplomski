mInterstitialAd = new InterstitialAd(this);
adRequest = new AdRequest.Builder().build();
mInterstitialAd.setAdUnitId("ca-app-pub-xxxxxxxxx");

mInterstitialAd.setAdListener(new AdListener() {

    @Override
    public void onAdLoaded(){
          //The ad is ready call it when the timing is right
        }
});

mInterstitialAd.loadAd(adRequest);