DisplayMetrics metrics = new DisplayMetrics();
getWindowManager().getDefaultDisplay().getMetrics(metrics);

height = metrics.heightPixels;
width = metrics.widthPixels;

double topMenuWidthScale = 0.1;
int topMenuWidth = (int)(topMenuWidthScale * width);

menuBtn = (ImageButton)findViewById(R.id.menuBtn);

menuBtn.setLayoutParams(new RelativeLayout.LayoutParams(topMenuWidth, topMenuWidth));