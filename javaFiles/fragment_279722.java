private Bitmap cropBitmap1()
{
    Bitmap bmp2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.image1); 
    Bitmap bmOverlay = Bitmap.createBitmap(bmp2.getWidth(), 1, Bitmap.Config.ARGB_8888);

    Paint p = new Paint();
    p.setXfermode(new PorterDuffXfermode(Mode.CLEAR));              
    Canvas c = new Canvas(bmOverlay); 
    c.drawBitmap(bmp2, 0, 0, null); 
    c.drawRect(30, 30, 100, 100, p);

    return bmOverlay;
}