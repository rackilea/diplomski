public void showMarker(Space space) {
    Bitmap bitmap =  BitmapFactory.decodeResource(getResources(),
        R.drawable.your_marker_image);
    Image image = new Image();
    image.setBitmap(bitmap);

    m_marker = new MapMarker(space.getCenter(), image);
    // Set anchor point to the centre-bottom area of the marker
    m_marker.setAnchorPoint(new PointF(image.getWidth() / 2f, image.getHeight()));
    m_marker.setOverlayType(MapOverlayType.FOREGROUND_OVERLAY);
    m_marker.setZIndex(100);

    // You can get map from VenueMapFragment, for example.
    getMap().addMapObject(m_marker);
}