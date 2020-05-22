private class ParseJSONTask extends AsyncTask<Void, Void, List<MarkerOptions>> {
    @Override
    protected void onPreExecute() {

        super.onPreExecute();
    }

    @Override
    protected List<MarkerOptions> doInBackground(Void... params) {
        WebServiceHandler webServiceHandler = new WebServiceHandler();
        String jsonstr = webServiceHandler
                .getJSONData("http://54.186.247.213/unicabi/mobileservice/CurrentLocationService.php");
        try {
            JSONObject jsonObject = new JSONObject(jsonstr);
            JSONArray postJson = jsonObject.getJSONArray(TAG_POSTS);
            List<MarkerOptions> markers = new ArrayList<MarkerOptions>();
            for (int i = 0; i < postJson.length(); i++) {
                Taxi aTaxi = new Taxi();
                JSONObject postObject = postJson.getJSONObject(i);
                aTaxi.lat = postObject.getString(TAG_LATITUDE);
                aTaxi.lon = postObject.getString(TAG_LONGITUDE);
                aTaxi.driver_name = postObject.getString(TAG_DRIVERNAME);
                taxi.add(aTaxi);
                double lati = Double.parseDouble(aTaxi.lat);
                double lon = Double.parseDouble(aTaxi.lon);
                markers.add(new MarkerOptions().title(aTaxi.driver_name).
                        position(new LatLng(lati, lon)));

                return markers;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<MarkerOptions>();
    }

    @Override
    protected void onPostExecute(List<MarkerOptions> markers) {
        super.onPostExecute(markers);
        for (MarkerOptions marker : markers) {
            googlemap.addMarker(marker);
        }
    }
}