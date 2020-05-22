mMap.clear();
MarkerOptions marker = new MarkerOptions()
                .position(new LatLng(latitude, longitude))
                .title("My Position")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

                mMap.addMarker(marker);