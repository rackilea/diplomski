private void updateCanvas() {
    // Clear the canvas for new iteration of drawing
    mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

    // TODO: determine/update x, y, radius, paint as a function of animation progress
    // i.e. for a fade effect, set the paint color to a diminishing alpha level
    mPaint.setColor(mPulseColor);
    mCanvas.drawCircle(x, y, radius, mPaint);
}