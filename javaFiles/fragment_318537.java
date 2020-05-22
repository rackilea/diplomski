mapview.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    CameraUpdate myLocation = CameraUpdateFactory.newLatLngZoom(yourLatLng, ZOOM_MAP);
                    googleMap.animateCamera(myLocation);
                }
            });