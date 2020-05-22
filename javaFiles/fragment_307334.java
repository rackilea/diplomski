@Override
protected synchronized void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    Paint textPaint = new Paint();
    textPaint.setAntiAlias(true);
    textPaint.setColor(textColor);
    textPaint.setTextSize(textSize);
    Rect bounds = new Rect();
    textPaint.getTextBounds(text, 0, text.length(), bounds);

    float density = getContext().getResources().getDisplayMetrics().density;
    float percentage = getProgress() / 100.0f;
    float x = getWidth() * percentage - (20 * density);
    float y = getHeight() / 2 - bounds.centerY();
    canvas.drawText(text, x, y, textPaint);
}