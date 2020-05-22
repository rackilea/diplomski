@Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    Bitmap map = BitmapFactory.decodeResource(getResources(), R.drawable.map);
    canvas.drawBitmap(map, xPositionForMap, yPositionForMap, null);

    Bitmap marker = BitmapFactory.decodeResource(getResources(), R.drawable.marker);
    canvas.drawBitmap(marker, xPositionFor1stMarker, yPositionFor1stMarker, null);
    canvas.drawBitmap(marker, xPositionFor2ndMarker, yPositionFor2ndMarker, null);
}