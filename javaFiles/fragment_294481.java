ImageView mImg1 = (ImageView) findViewById(R.id.mImg1);
// For get Drawable from Image
Drawable d = mImg1.getDrawable();

// For Convert Drawable to Bitmap
Bitmap bitmapOrg = ((BitmapDrawable)d).getBitmap();