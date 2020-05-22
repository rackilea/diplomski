button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mMap.clear();
            if (button1.isShown()) {
                mMap.addMarker(new MarkerOptions().position(new LatLng(, )).title("").snippet("My Location").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));

            }
        }
    });

    button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mMap.clear();
            if (button2.isShown()) {
                mMap.addMarker(new MarkerOptions().position(new LatLng()).title("").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_hospital)));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(), ));


            }
        }
    });

    button3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mMap.clear();
            if (button3.isShown()) {
                mMap.addMarker(new MarkerOptions().position(new LatLng(`enter code here`)).title(" ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_busstop)));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(), ));
            }
        }
    });