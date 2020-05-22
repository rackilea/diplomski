protected void onDraw(Canvas canvas) {
    // your paint code
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        if (isFocused()) { // draw the border
            canvas.drawRoundRect(0, 0, getWidth(), getHeight(), 10, 10, strokePaint);
            canvas.drawRoundRect(0 + 3, 0 + 3, getWidth() - 3, getHeight() - 3, 7, 7, fillPaint);
        } else { // don't draw the border
            canvas.drawRoundRect(0, 0, getWidth(), getHeight(), 7, 7, fillPaint);
        }
    } else {
        //similar here
    }
    // The rest of your code
}