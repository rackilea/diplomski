LinearLayout row = (LinearLayout) findViewById(R.id.rowFile);
ImageView image = (ImageView) findViewById(R.id.img_dilvChat);

row.removeView(image);
row.addView(image);

row.invalidate();