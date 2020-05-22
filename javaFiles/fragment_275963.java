@Override
protected void onDraw(Canvas canvas) {
    int w = 1000, h = 1500;
    Bitmap.Config conf = Bitmap.Config.ARGB_8888;
    Bitmap bmp = Bitmap.createBitmap(w, h, conf);
    Canvas mycanvas = new Canvas(bmp);
    super.onDraw(mycanvas);

    ...
}