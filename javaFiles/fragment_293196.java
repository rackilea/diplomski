private int mHeight = 0;

 @Override
protected void onDraw(Canvas canvas) {

    paint.setColor(Color.RED);
    paint2.setColor(Color.DKGRAY);
    canvas.drawRect(150, 0, 200, 150 + mHeight, paint);
    canvas.drawRect(200, 0, 250, 200 + mHeight, paint2);
}

public void setRectHeight(final int height) {
    mHeight = height;
    invalidate();
}