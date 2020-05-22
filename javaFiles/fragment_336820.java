private final Stack<JSONObject> mPending = new Stack<>();

@Override
public void onMapReady(GoogleMap googleMap) {
    Log.i("Carregou", "Mapa");
    _googleMap = googleMap;
    syncMarkers(); // <=== LOOK HERE
    _googleMap.setMyLocationEnabled(true);
    _googleMap.getUiSettings().setMyLocationButtonEnabled(false);

    loadConnectedProviders();

    _googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
        @Override
        public void onMyLocationChange(Location location) {
            if (_isSubscribedToPresence) {
                LatLng coordinates = new LatLng(location.getLatitude(), location.getLongitude());
                _googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 15));
                Log.d(Utils.TAG, "Atualizou localização");
                _googleMap.setMyLocationEnabled(false);
                _googleMap.addMarker(new MarkerOptions().position(coordinates)).setTitle("Minha localização");

                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("id", _user.getId());
                    jsonObject.put("latitude", coordinates.latitude);
                    jsonObject.put("longitude", coordinates.longitude);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                _presenceChannel.trigger("client-locup", jsonObject.toString());
            }
        }
    });

}

    @Override
    public void onEvent(String channelName, String eventName, String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            mPending.add(jsonObject);
            syncMarkers(); // <=== LOOK HERE
            Log.d(Utils.TAG, "Id is " + userId + " Value of lat is " + latLng.latitude + " and long is " + latLng.longitude);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void syncMarkers() {
        if (_googleMap != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    while (!mPending.empty()) {
                        JSONObject jsonObject = mPending.pop();
                        int userId = jsonObject.getInt("id");
                        LatLng latLng = new LatLng(jsonObject.getDouble("latitude"), jsonObject.getDouble("longitude"));
                        _googleMap.addMarker(new MarkerOptions().position(latLng));
                    }
                }
            });
        }
    }