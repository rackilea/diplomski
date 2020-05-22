NativeExpressAdView adView = new NativeExpressAdView(this);
 adView.setId(R.id.nativeExpressAdId);
 int height = 80; // or whatever is appropriate - make sure its >= ad minimum
 // set the size to the width of the screen
 adView.setAdSize(new AdSize((int) (AdSize.FULL_WIDTH, height));
 adView.setAdUnitId(getString(R.string.adUnitId));
 // assuming this goes in a linearlayout... you can also addRules to lp
 LinearLayout.LayoutParams lp = new 
      LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 
      LinearLayout.LayoutParams.MATCH_PARENT);
 // set margins manually (`.setMargins()`) or add rules with (`.addRule()`)
 // or .setVisibility() etc... to lp
 adView.setLayoutParams(lp);