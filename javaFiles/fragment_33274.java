Marker marker = mMap.addMarker(new MarkerOptions()
                      .position(location)
                      .title(poi.getName())
                      .snippet(poi.getDescription())
                      .icon(BitmapDescriptorFactory.fromBitmap(image_item));
marker.showInfoWindow();