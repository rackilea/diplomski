Marker marker = myMap.addMarker(new MarkerOptions()
                 .position(latLng)
                 .title("Title")
                 .snippet("Snippet")
                 .icon(BitmapDescriptorFactory
                 .fromResource(R.drawable.marker)));
 marker.showInfoWindow();