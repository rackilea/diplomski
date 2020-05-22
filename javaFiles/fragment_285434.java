List<Marker> list = new ArrayList<Marker>();

  for(int i = 0; i < Lat.length; i++)
  {
     Marker marker = map.addMarker(new MarkerOptions()
        .position(new LatLng(Lat[i], Lon[i]))
        .title(Market[i])
        .snippet(Address[i])
        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
     list.add(marker);
  }