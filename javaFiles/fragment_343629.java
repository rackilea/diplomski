@Override
protected void onDraw(Canvas canvas) {

canvas.drawBitmap(mBitmap,0,0,mBitmapPaint);             // NPE here 

    for (Path p : paths) {
        canvas.drawPath(p, mPaint);                     
    }
}