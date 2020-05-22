/**Latlng's to get focus*/
    LatLng Delhi = new LatLng(28.61, 77.2099);
    LatLng Chandigarh = new LatLng(30.75, 76.78);
    LatLng SriLanka = new LatLng(7.000, 81.0000);
    LatLng America = new LatLng(38.8833, 77.0167);
    LatLng Arab = new LatLng(24.000, 45.000);

    /**create for loop/manual to add LatLng's to the LatLngBounds.Builder*/
    LatLngBounds.Builder builder = new LatLngBounds.Builder();
    builder.include(Delhi);
    builder.include(Chandigarh);
    builder.include(SriLanka);
    builder.include(America);
    builder.include(Arab);

    /**initialize the padding for map boundary*/
    int padding = 50;
    /**create the bounds from latlngBuilder to set into map camera*/
    LatLngBounds bounds = builder.build();
    /**create the camera with bounds and padding to set into map*/
    final CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
    /**call the map call back to know map is loaded or not*/
    map.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
        @Override
        public void onMapLoaded() {
            /**set animated zoom camera into map*/
            map.animateCamera(cu);
        }
    });