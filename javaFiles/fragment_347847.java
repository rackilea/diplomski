int density= getResources().getDisplayMetrics().densityDpi;

switch(density)
{
case DisplayMetrics.DENSITY_LOW:
    Log.d(TAG, "LDPI");
    break;
case DisplayMetrics.DENSITY_MEDIUM:
     Log.d(TAG, "MDPI");
    break;
case DisplayMetrics.DENSITY_HIGH:
    Log.d(TAG, "HDPI");
    break;
case DisplayMetrics.DENSITY_XHIGH:
     Log.d(TAG, "XHDPI");
    break;
}