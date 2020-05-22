markerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              // check if user has not set location yet.

                if (myCurrentLatitude == null | myCurrentLongitude == null){
                    Toast.makeText(EventViewActivity.this, "Please choose your location first", Toast.LENGTH_SHORT).show();
                    return;
                }
                LatLng myCurrentLocation = new LatLng(myCurrentLatitude, myCurrentLongitude);
                marker = mMap.addMarker(new MarkerOptions().position(myLocation).title("New Marker"));
                markerBtn.setTag("yo");

            });