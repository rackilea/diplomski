protected float mStartX;
protected float mStartY;

protected float mx;
protected float my;

private void drawLine(android.graphics.Canvas canvas) {

    float dx = Math.abs(mx - mStartX);
    float dy = Math.abs(my - mStartY);
    if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
        canvas.drawLine(mStartX, mStartY, mx, my, mPaint);
    }
}

private void lineDrawEvent(MotionEvent event) {
    switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            isDrawing = true;
            // If this is the first line then the start values will be
            // uninitialised, so only use them for the start of the first line
            // Otherwise they will be set by the previous UP event
            if (mStartX == null && mStartY == null) {
              mStartX = mx;
              mStartY = my;
            }
            invalidate();
            break;
        case MotionEvent.ACTION_MOVE:
            invalidate();
            break;
        case MotionEvent.ACTION_UP:
            isDrawing = false;
            mCanvas.drawLine(mStartX, mStartY, mx, my, mPaintFinal);
            // Set the Start point of the next line to end of current
            mStartX = mx;
            mStartY = my;
            invalidate();
            break;
    }
}