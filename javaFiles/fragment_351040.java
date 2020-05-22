void doIt(ImageView image)
{
    //get bitmap from your ImageView (image)
    Bitmap originalBitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();

    int height = originalBitmap.getHeight();
    int fortyPercentHeight = (int) Math.floor(height * 40.0 / 100.0);

    //create a bitmap of the top 40% of image height that we will make black and white
    Bitmap croppedBitmap = Bitmap.createBitmap(originalBitmap, 0, 0, originalBitmap.getWidth() , fortyPercentHeight );
    //make it monochrome
    Bitmap blackAndWhiteBitmap = monoChrome(croppedBitmap);
    //copy the monochrome bmp (blackAndWhiteBitmap) to the original bmp (originalBitmap)
    originalBitmap = overlay(originalBitmap, blackAndWhiteBitmap);
    //set imageview to new bitmap
    image.setImageBitmap(originalBitmap );
}

Bitmap monoChrome(Bitmap bitmap)
{
    Bitmap bmpMonochrome = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bmpMonochrome);
    ColorMatrix ma = new ColorMatrix();
    ma.setSaturation(0);
    Paint paint = new Paint();
    paint.setColorFilter(new ColorMatrixColorFilter(ma));
    canvas.drawBitmap(bitmap, 0, 0, paint);
    return bmpMonochrome;
}

Bitmap overlay(Bitmap bmp1, Bitmap bmp2) 
{
    Bitmap bmp3 = bmp1.copy(Bitmap.Config.ARGB_8888,true);//mutable copy
    Canvas canvas = new Canvas(bmp3 );
    canvas.drawBitmap(bmp2, new Matrix(), null);
    return bmp3 ;
}