private AdView ad;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);

          setContentView(R.layout.yourlayout);

          initAdView();

          // other code...
      }

       protected void initAdView() {

            ad = new AdView(this, AdSize.SMART_BANNER, "MY_AD_UNIT_ID");

            LinearLayout ll = (LinearLayout) findViewById(R.id.adviewPlaceholder);

            ll.addView(ad);

            ad.loadAd(new AdRequest());
        }

        protected void destroyAdView() {
            if(ad != null) ad.destroy();
        }

        @Override
        protected void onDestroy() {    
            // destroy the ad when the activity is destroyed
            destroyAdView();
            super.onDestroy();
        }