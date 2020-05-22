private void showBannerAds() {

        LinearLayout adBannerLayout = (LinearLayout) findViewById(R.id.layout_banner_holder);

        adView = new AdView(this);
        adView.setAdUnitId(ca-app-pub-3940256099942544/6300978111);
        adView.setAdSize(AdSize.SMART_BANNER);
        adBannerLayout.addView(adView);

        AdRequest adRequest;

            adRequest = new AdRequest.Builder().build();

        adView.loadAd(adRequest);

    }