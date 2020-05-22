View adContainer = findViewById(R.id.adMobView);
AdView mAdView = new AdView(context);
mAdView.setAdSize(AdSize.BANNER);
mAdView.setAdUnitId(YOUR_BANNER_ID);
adContainer.addView(mAdView);
AdRequest adRequest = new AdRequest.Builder().build();
mAdView.loadAd(adRequest);