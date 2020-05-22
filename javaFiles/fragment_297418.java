for (int i = 1; i < points.size(); i++) {
    Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.cutedot);
    Canvas canvas = new Canvas(bitmap);
    canvas.drawText(i+"", textXOffset, textYOffset, mPictoPaint);
    MarkerOptions options = new     MarkerOptions().position(points.get(i)).anchor(0.5f,1).icon(BitmapDescriptorFactory.fromBitmap(bitmapResul    t    ));
    Marker newMarker = googleMap.addMarker(options);

}