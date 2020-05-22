private void GeoFence()
    {
        for (Map.Entry<String, Map.Entry<LatLng,Integer>> entry : Constants.MAIN_GEOFENCES.entrySet()) {
            setGeoQuery(entry);
        }

    }

    private void setGeoQuery(Map.Entry<String, Map.Entry<LatLng,Integer>> entry){
        GeoQuery geoQuery = geoFire.queryAtLocation(new GeoLocation(entry.getValue().getKey().latitude,entry.getValue().getKey().longitude),0.5f);
        geoQuery.addGeoQueryEventListener(new GeoQueryEventListener() {
            @Override
            public void onKeyEntered(String key, GeoLocation location) {
                Log.e("triggered for "+entry.getKey(),"lat:"+entry.getValue().getKey().latitude+",lng:"+entry.getValue().getKey().longitude);
                TriggeredGeoFence(String.format("Key %s entered the search area at [%f,%f]", key, location.latitude, location.longitude));
                System.out.println(String.format("Key %s entered the search area at [%f,%f]", key, location.latitude, location.longitude));
            }

            @Override
            public void onKeyExited(String key) {
                TriggeredGeoFence("Exited");
            }

            @Override
            public void onKeyMoved(String key, GeoLocation location) {

            }

            @Override
            public void onGeoQueryReady() {
             Log.e("triggered for "+entry.getKey(),"lat:"+entry.getValue().getKey().latitude+",lng:"+entry.getValue().getKey().longitude);
            }

            @Override
            public void onGeoQueryError(DatabaseError error) {

            }
        });
    }