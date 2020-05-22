RelativeLayout layout = new RelativeLayout(this);

requestWindowFeature(Window.FEATURE_NO_TITLE);
getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
View gameView = initializeForView(new RedSquare(), cfg);

AdView AdView = new AdView(this);
AdView.setAdSize(AdSize.SMART_BANNER);
AdView.setAdUnitId("***"); //The AdUnitId
AdRequest.Builder adRequest = new AdRequest.Builder();
adRequest.addTestDevice("***"); //Your Test device if any
AdView.loadAd(adRequest.build());

layout.addView(gameView);

RelativeLayout.LayoutParams adParams = 
    new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, 
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
adParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
adParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

layout.addView(AdView, adParams);

setContentView(layout);