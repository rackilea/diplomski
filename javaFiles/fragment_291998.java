@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mAd = MobileAds.getRewardedVideoAdInstance(this);

    mAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {

        @Override
        public void onRewarded(RewardItem rewardItem) {
            switch(Constants.currentAd) {
                case("REWARD1"):
                    //do something
                    Constants.currentAd = "";
                    break;

                case("REWARD2"):
                    //do something
                    Constants.currentAd = "";
                    break;

                case("REWARD3"):
                    //do something
                    Constants.currentAd = "";
                    break;
            }
        }
    });

   mAd.loadAd("REWARDED_VIDEO_UNIT_ID", new AdRequest.Builder().build());
}

public void showRewardedVideo() {
        if (mAd.isLoaded()) {
            mAd.show();
        }
    }