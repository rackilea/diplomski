// latitude and longitude
    double latitude1 =51.525516;
    double longitude1 =-0.460905;

 // create marker
    MarkerOptions markerOptions1 = new MarkerOptions().position(new LatLng(latitude1,        longitude1)).title("Jack ").snippet("Hillingdon Hospital").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));


    // adding marker
    Marker marker1 = googleMap.addMarker(markerOptions1);
    marker1.showInfoWindow();


    // check if map is created successfully or not
    if (googleMap == null) {
        Toast.makeText(getApplicationContext(),
                "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                .show();
    }