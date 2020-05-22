// Create the interstitial.
interstitial = new InterstitialAd(this);
//interstitial.setAdUnitId(AdRequest.DEVICE_ID_EMULATOR);
// Create ad request.
AdRequest adRequestI = new AdRequest.Builder().addTestDevice("B3EEABB8EE11C2BE770B684D95219").build();
// Begin loading your interstitial.
interstitial.loadAd(adRequestI);