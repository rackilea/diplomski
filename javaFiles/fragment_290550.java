Bitmap images[4];
void loadFrames()
{
    res = getResources();
    images[0] = BitmapFactory.decodeResource(res, R.drawable.image_1);
    images[1] = BitmapFactory.decodeResource(res, R.drawable.image_2);
    images[2] = BitmapFactory.decodeResource(res, R.drawable.image_3);
    images[3] = BitmapFactory.decodeResource(res, R.drawable.image_4);
}