public void what3words() {

    // some initial default position
    LatLng pt = new LatLng(38.547279, -121.461019);

    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

    // move map to a coordinate
    CameraUpdate cu = CameraUpdateFactory.newLatLng(pt);
    mMap.moveCamera(cu);
    cu = CameraUpdateFactory.zoomTo(14);
    mMap.moveCamera(cu);

    mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
        @Override
        public void onMapClick(LatLng latLng) {
            mMap.addCircle(new CircleOptions().radius(4).strokeColor(Color.BLUE).center(latLng));
        }
    });

    // while the camera is moving just move the grid (realign on idle)
    mMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
        @Override
        public void onCameraMove() {
            ((GridView) findViewById(R.id.grid_any)).setAlignment(
                    null, mMap.getProjection(), mMap.getProjection().getVisibleRegion());
        }
    });

    // on idle fetch the grid using the screen center point
    mMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
        @Override
        public void onCameraIdle() {
            Log.d(TAG,"idle");


            final LatLng centerOfGridCell = mMap.getCameraPosition().target;

            if (!gridSet || mMap.getCameraPosition().zoom < 10) {
                getGrid(centerOfGridCell, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "reqpt: " + centerOfGridCell + " volley response: " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("lines");
                            JSONObject firstList = jsonArray.getJSONObject(1);
                            JSONObject firstPt = firstList.getJSONObject("start");
                            String lat = firstPt.getString("lat");
                            String lng = firstPt.getString("lng");
                            Log.d(TAG, "lat: " + lat + " lng: " + lng);

                            LatLng alignmentPt = new LatLng(Double.parseDouble(lat), Double.parseDouble(lng));
                            Projection p = mMap.getProjection();
                            VisibleRegion vr = p.getVisibleRegion();


                            ((GridView) findViewById(R.id.grid_any)).setAlignment(alignmentPt, p, vr);

                            if (polygon != null) {
                                polygon.remove();
                            }

                            // take alignment point and draw 3 meter square polygon
                            LatLng pt1 = SphericalUtil.computeOffset(alignmentPt, 3, 90);
                            LatLng pt2 = SphericalUtil.computeOffset(pt1, 3, 180);
                            LatLng pt3 = SphericalUtil.computeOffset(pt2, 3, 270);

                            polygon = mMap.addPolygon(new PolygonOptions().add(alignmentPt,
                                    pt1, pt2, pt3, alignmentPt)
                                    .strokeColor(Color.BLUE).strokeWidth(4).fillColor(Color.BLUE));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                });

                gridSet = true;
            }


        }
    });
}


// Issue request to w3w - REMEMBER TO REPLACE **YOURKEY** ...
private void getGrid(LatLng pt, Response.Listener<String> listener) {

    // something 9 meters to east
    LatLng otherPt = SphericalUtil.computeOffset(pt, 6.0, 225);
    String bboxStr = Double.toString(pt.latitude)+","+
            Double.toString(pt.longitude)+","+
            Double.toString(otherPt.latitude)+","+
            Double.toString(otherPt.longitude);
    RequestQueue rq = Volley.newRequestQueue(this);
    String url = "https://api.what3words.com/v2/grid?bbox="+bboxStr+"&format=json&key=YOURKEY";

    Log.d(TAG,"url="+url);
    StringRequest req = new StringRequest(Request.Method.GET, url, listener, new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e(TAG, "volley error: "+error);
        }
    });

    rq.add(req);
}