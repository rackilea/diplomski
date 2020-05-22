@Override
protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);

    mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
    //set background color
    mBitmap.eraseColor(0xFFAAAAAA);
    mCanvas = new Canvas(mBitmap);
}