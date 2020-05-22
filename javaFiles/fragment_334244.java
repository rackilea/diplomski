public void addPolylineToMap(GoogleMap map, List<LatLng> route) {
    final PolylineOptions polyline = new PolylineOptions();

    for (LatLng point : route) {
        polyline.add(point);
    }

    polyline.width(5)
            .color(Color.RED);

    map.addPolyline(polyline);
}