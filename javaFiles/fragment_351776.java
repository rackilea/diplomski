DisplayMetrics displaymetrics = new DisplayMetrics();
int mPageHeight = displaymetrics.heightPixels;

LinearLayout.LayoutParams lp = new LineaLayout.LayoutParams(width, mPageHeight/2);

yourview.setLayoutParams(lp);