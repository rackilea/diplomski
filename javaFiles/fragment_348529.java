public class AndroidAdsManager implements AdsManager {
  private AdView adBanner;
  private AdHandler adHandler;

    @Override
    public void showAds(boolean show) {
        adHandler.sendEmptyMessage(show ? adHandler.ADS_SHOW : adHandler.ADS_HIDE);
    }
    @Override
    public void implementAds() {
        // Implement ads
        MobileAds.initialize(this, ""); // HERE YOU NEED TO GET THE CONTEXT

        adHandler = new AdHandler();
        adHandler.adBanner = new AdView(this);
        adHandler.adBanner.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Log.i(TAG, "Ad loaded ...");
            }
        });

        adHandler.adBanner.setAdSize(AdSize.SMART_BANNER);
        adHandler.adBanner.setAdUnitId("");
    }
    // You need to get a RelativeLayout reference for this method to work
    // I would get it from AndroidLauncher
    public void requestAds() {
        AdRequest.Builder builder = new AdRequest.Builder();
        builder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        builder.addTestDevice("");

        RelativeLayout.LayoutParams adBannerParams = new 
        RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 
        ViewGroup.LayoutParams.WRAP_CONTENT);
        adBannerParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        adBannerParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);

        layout.addView(adHandler.adBanner, adBannerParams);
        adHandler.adBanner.loadAd(builder.build());
    }
}