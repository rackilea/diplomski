Bitmap bitmap= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.yourRes);
myBitmap=immutableBmp.copy(Bitmap.Config.ARGB_8888, true);

int [] pixels = new int [myBitmap.getHeight() * myBitmap.getWidth()];

myBitmap.getPixels(pixels, 0, myBitmap.getWidth(), 0, 0, myBitmap.getWidth(), myBitmap.getHeight());

for(int i = 0; i < pixels.length; i++)
{
    if(pixels[i] == Color.RED)
    {
        pixels[i] = Color.YELLOW;
    }
}

myBitmap.setPixels(pixels,0,myBitmap.getWidth(),0, 0, myBitmap.getWidth(),myBitmap.getHeight());