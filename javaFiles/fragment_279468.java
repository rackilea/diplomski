mView = new SDLSurfaceView(
            this,
            mPath.getAbsolutePath());
Hardware.view = mView;

//CREATE WIDGETS LAYOUT PARAMETERS
FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
    FrameLayout.LayoutParams.WRAP_CONTENT,
    FrameLayout.LayoutParams.WRAP_CONTENT,
    Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL);

//CREATE ADVIEW
adView = new AdView(this);
adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
adView.setAdSize(AdSize.BANNER);
adView.setVisibility(View.GONE);

//ADD LAYOUT PARAMETER TO ADVIEW
adView.setLayoutParams(lp);

//SET AD LISTENER
adView.setAdListener(new AdListener() {
        @Override
        public void onAdLoaded() {
            super.onAdLoaded();
            adView.setVisibility(View.VISIBLE);

        }

        @Override
        public void onAdFailedToLoad(int errorCode) {
            super.onAdFailedToLoad(errorCode);
            adView.setVisibility(View.GONE);

        }
    });

//CREATE LAYOUT
FrameLayout layout = new FrameLayout(this);
//SET CONTENT TO LAYOUT
setContentView(layout);
//ADD VIEWS TO LAYOUT
layout.addView(mView);
layout.addView(adView);
//BUILD AD REQUEST
AdRequest adRequest = new AdRequest.Builder()
    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
    .build();
adView.loadAd(adRequest);