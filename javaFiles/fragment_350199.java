itmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.yourdrawable)

MarkerOptions markerOptions = new MarkerOptions().position(latLng)
         .title("Current Location")
         .snippet("Thinking of finding some thing...")
         .icon(icon);

mMarker = googleMap.addMarker(markerOptions);