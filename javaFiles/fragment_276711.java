private Bitmap decodeImage(String data)
{
    byte[] b = Base64.decode(data,Base64.DEFAULT);
    Bitmap bmp = BitmapFactory.decodeByteArray(b,0,b.length);
    return bmp;
}