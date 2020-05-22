mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
        @Override
        public void onMyLocationChange(Location location) {
            mLocation = location;
            if(loadLocation.equals("notDone")){
                displayCurrentLocation();
            }
        }
    });