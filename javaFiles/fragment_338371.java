LatLng NEWARK = new LatLng(40.714086, -74.228697);

GroundOverlayOptions newarkMap = new GroundOverlayOptions()
    .image(BitmapDescriptorFactory.fromResource(R.drawable.newark_nj_1922))
    .position(NEWARK, 8600f, 6500f);
map.addGroundOverlay(newarkMap);