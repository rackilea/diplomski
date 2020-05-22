private void drawBounds (LatLngBounds bounds, int color) {
    PolygonOptions polygonOptions =  new PolygonOptions()
            .add(new LatLng(bounds.northeast.latitude, bounds.northeast.longitude))
            .add(new LatLng(bounds.southwest.latitude, bounds.northeast.longitude))
            .add(new LatLng(bounds.southwest.latitude, bounds.southwest.longitude))
            .add(new LatLng(bounds.northeast.latitude, bounds.southwest.longitude))
            .strokeColor(color);

    mMap.addPolygon(polygonOptions);
}