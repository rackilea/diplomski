Display display = getWindowManager().getDefaultDisplay();
DisplayMetrics outMetrics = new DisplayMetrics ();
display.getMetrics(outMetrics);

float density  = getResources().getDisplayMetrics().density;
float dpWidth  = outMetrics.widthPixels / density;