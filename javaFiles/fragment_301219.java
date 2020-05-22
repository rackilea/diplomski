private void setMarkerOnMap(double latitude, double longitude) {

        if (marker == null) {
            marker = map.addMarker(new MarkerOptions().position((new LatLng(latitude, longitude))));
            marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.pin_blue));
        } else {
            marker.setPosition(new LatLng(latitude, longitude));
        }

        Projection projection = map.getProjection();
        LatLng markerLatLng = new LatLng(marker.getPosition().latitude, marker.getPosition().longitude);

        Point markerScreenPosition = projection.toScreenLocation(markerLatLng);
        Point pointHalfScreenAbove = new Point(markerScreenPosition.x, (markerScreenPosition.y - (mapViewHeightFull / 2)) + mapViewHeightHalfPart);
        LatLng aboveMarkerLatLng = projection.fromScreenLocation(pointHalfScreenAbove);

        CameraUpdate camPosition = CameraUpdateFactory.newLatLngZoom(aboveMarkerLatLng, defaultZoom);

        map.animateCamera(camPosition);
    }