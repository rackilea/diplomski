private static final String AD_UNIT_ID_INTERSTITIAL = "ca-app-pub-XXXXX/XXXXX";

private InterstitialAd interstitialAd;

@Override
protected void onCreate (Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ...
    ...

    interstitialAd = new InterstitialAd(this);
    interstitialAd.setAdUnitId(AD_UNIT_ID_INTERSTITIAL);
    interstitialAd.setAdListener(new AdListener() {
          @Override
          public void onAdLoaded() {}

          @Override
          public void onAdClosed() {
             loadIntersitialAd();
          }
    });

    loadIntersitialAd();
}


private void loadIntersitialAd(){

    AdRequest interstitialRequest = new AdRequest.Builder().build();
    interstitialAd.loadAd(interstitialRequest);
}

@Override 
public void showOrLoadInterstitial() {

     runOnUiThread(new Runnable() {
            public void run() {
                if (interstitialAd.isLoaded()) 
                     interstitialAd.show();                         
                else 
                     loadIntersitialAd();           
            }
      });
}