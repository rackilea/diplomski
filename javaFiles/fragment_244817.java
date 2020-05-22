RelativeLayout rlMain = (RelativeLayout) findViewById(R.id.mainLayout);

ImageView iv = new ImageView(this);
iv.setImageResource(R.drawable.orb1);
RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(80, 80);
params.topMargin=50;
params.leftMargin=50;
rlMain.addView(iv, params);