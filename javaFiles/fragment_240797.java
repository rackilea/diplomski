public void drawRouteAsync() {
    GeoPoint location = new GeoPoint(Double.parseDouble(place.getLongitude()),
            Double.parseDouble(place.getLatitude()));
    GeoPoint myLocation = new GeoPoint(51.488978, 6.746994);

    new RouteAsyncTask().execute(location, myLocation);
}

private class RouteAsyncTask extends AsyncTask<GeoPoint, Void, Road> {
    @Override
    protected Road doInBackground(GeoPoint... params) {
        ArrayList<GeoPoint> waypoints = new ArrayList<GeoPoint>();
        waypoints.add(params[0]); // location
        waypoints.add(params[1]); // myLocation
        RoadManager roadManager = new OSRMRoadManager(mContext); // your context
        Road road = roadManager.getRoad(waypoints); // time consuming
        return road;
    }

    @Override
    protected void onPostExecute(Road road) {
        Polyline roadOverlay = RoadManager.buildRoadOverlay(road);
        map.getOverlays().add(roadOverlay); // update view
    }
}