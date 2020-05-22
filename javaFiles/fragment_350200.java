private Bitmap changeBitmapColor(Bitmap sourceBitmap, int color) {

    Bitmap resultBitmap = Bitmap.createBitmap(sourceBitmap, 0, 0,
            sourceBitmap.getWidth() - 1, sourceBitmap.getHeight() - 1);
    Paint p = new Paint();
    ColorFilter filter = new LightingColorFilter(color, 1);
    p.setColorFilter(filter);
    Canvas canvas = new Canvas(resultBitmap);
    canvas.drawBitmap(resultBitmap, 0, 0, p);
    return resultBitmap;
}