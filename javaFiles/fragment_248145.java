RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(null);
params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);
Menu menu = new Menu();
menu.setLayoutParams(params);
ad.getAd().setLayoutParams(params);
game.addView(menu);
game.addView(ad.getAd());