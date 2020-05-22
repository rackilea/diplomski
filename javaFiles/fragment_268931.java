private Marker myMarker = null;
if (myMarker == null)
    myMarker = mMap.addMarker(new MarkerOptions())
                    .position(route.getPositions().get(i))
                    .icon(BitmapDescriptorFactory
                    .defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
else
  myMarker.setPosition(route.getPositions().get(i));