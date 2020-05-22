Result mResult;
new MethodChannel(getFlutterView(), CHANNEL).setMethodCallHandler(
    new MethodCallHandler() {
        @Override
        public void onMethodCall(MethodCall call, Result result) {
            if (call.method.equals("loadInterstitialAd")) {
              IronSource.loadInterstitial();
              mResult = result;//save the result
            } else {
              result.notImplemented();
            }
        }
    });

 public void onInterstitialAdLoadFailed(){
     mResult.success(0);
 }
 public void onInterstitialAdOpened(){
     mResult.success(1);
 }
 public void onInterstitialAdClosed(){
     mResult.success(2);
 }
 public void onInterstitialAdShowSucceeded(){
     mResult.success(3);
 }