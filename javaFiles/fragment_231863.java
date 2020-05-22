private void onMapReady(GoogleMap map){

 try {

        socket.on("miad", new Emitter.Listener() {
            @Override
            public void call(final Object... args) {

                try {

                    JSONObject data = (JSONObject) args[0];

                    runOnUiThread(new Runnable() {
                        LatLng latLng = new LatLng(newlat, newlng);
                        mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .title("First Pit Stop")
                            .icon(BitmapDescriptorFactory
                                     .defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                    });

                } catch (Exception e) {
                    Log.e("runOnUiThread", "Ex", e);
                }
            }
        });
    } catch (Exception e) {
        Log.e("onMapReady", "Ex", e);
    }
}