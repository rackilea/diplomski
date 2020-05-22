mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
        @Override
        public boolean onMarkerClick(Marker marker) {

            GoogleMap.OnMarkerClickListener listener = (GoogleMap.OnMarkerClickListener) marker.getTag();

            //Getting the lat and long based on marker position clicked
            Double latitude = marker.getPosition().latitude;
            Double longitude = marker.getPosition().longitude;

            getInfoJson(latitude, longitude);

            return listener != null && listener.onMarkerClick(marker);
        }
    });