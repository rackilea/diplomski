@Override
protected void onDraw(Canvas canvas) {
    canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint); // canvas
    canvas.drawPath(drawPath, fillPaint); // fill
    canvas.drawPath(drawPath, drawPaint); // stroke
}