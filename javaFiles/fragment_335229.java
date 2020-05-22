private Bitmap getBitmapFromView(View view) {
    view.buildDrawingCache();
    Bitmap returnedBitmap = Bitmap.createBitmap(view.measuredWidth,
            view.measuredHeight,
            Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(returnedBitmap);
    canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN);
    Drawable drawable = view.background;
    drawable.draw(canvas);
    view.draw(canvas);
    return returnedBitmap;
}