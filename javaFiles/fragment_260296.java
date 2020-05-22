private GoogleMap mMap;
 mMap.setInfoWindowAdapter(new InfoWindowAdapter() {

        @Override
        public View getInfoWindow(Marker arg0) {

             View v = getLayoutInflater().inflate(R.layout.your_custom_layout, null);
             return v;

        }

        @Override
        public View getInfoContents(Marker arg0) {

             return null;    
        }
    });