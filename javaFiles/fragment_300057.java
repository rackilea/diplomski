RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl1);

final Options bitmapOptions=new Options();
DisplayMetrics metrics = getResources().getDisplayMetrics();
bitmapOptions.inDensity = metrics.densityDpi;
bitmapOptions.inTargetDensity=1;

/*`final` modifier might be necessary for the Bitmap*/
Bitmap bmp= BitmapFactory.decodeResource(getResources(), R.drawable.ver_bottom_panel_tiled_long, bitmapOptions);
bmp.setDensity(Bitmap.DENSITY_NONE);
bmp = Bitmap.createBitmap(bmp, 0, 0, rl.getWidth(), bmp.getHeight());