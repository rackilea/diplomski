public class Home extends Activity {

private InterstitialAd interstitialAd;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    // Prepare the Interstitial Ad
   interstitialAd = new InterstitialAd(Home.this);
   interstitialAd.setAdUnitId(getString(R.string.interstitial_unit_id));
   AdRequest adRequest = new AdRequest.Builder().build();
   interstitialAd.loadAd(adRequest);
   interstitialAd.setAdListener(new AdListener() {
        public void onAdLoaded() {
            if (interstitialAd.isLoaded()) {
                interstitialAd.show();
            }
        }
    });


    /* do your other code here */
 }
}