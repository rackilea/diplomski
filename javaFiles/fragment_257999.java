DisplayMetrics dm = new DisplayMetrics();
getWindowManager().getDefaultDisplay().getMetrics(dm);

// will either be DENSITY_LOW, DENSITY_MEDIUM or DENSITY_HIGH
int dpiClassification = dm.densityDpi;

// these will return the actual dpi horizontally and vertically
 float xDpi = dm.xdpi;
 float yDpi = dm.ydpi;