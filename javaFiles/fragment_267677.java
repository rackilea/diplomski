admobAdView = new com.google.android.gms.ads.AdView(getActivity());
    admobAdView.setAdSize(AdSize.SMART_BANNER);
    admobAdView.setAdUnitId("ca-app-pub-###########/#######");
adViewContainer = (ViewGroup) getView().findViewById(R.id.ad_view_group);
AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("#################")
                .build();
admobAdView.loadAd(adRequest);