public void onResponse(Document doc, final GoogleDirection gd) {

String status = getStatus();
mMap.addMarker(new MarkerOptions()
        .position(
                new LatLng(myLocation.getLatitude(), myLocation
                        .getLongitude()))
        .icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
mMap.addMarker(new MarkerOptions().position(Position).icon(
        BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_RED)));

mMap.addPolyline(gd.getPolyline(doc, 3, Color.RED));
MyVariable = gd.getTotalDurationValue(doc);
}