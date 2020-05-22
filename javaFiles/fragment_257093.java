private class GetALLGPSTask extends AsyncTask<String, Void, List<Pair<String, LatLng>>> {
    private TextView textView;

    public GetALLGPSTask() {

    }

    @Override
    protected List<Pair<String, LatLng>> doInBackground(String... strings) {
        List<Pair<String, LatLng>> allLocations = new ArrayList<>();
        try {
            URL url = new URL(strings[0]);
            final String basicAuth = "Basic " + Base64.encodeToString("xxxx:xxxx@1223".getBytes(), Base64.NO_WRAP);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setReadTimeout(90000);
            urlConnection.setConnectTimeout(55000);
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
            urlConnection.setRequestProperty ("Authorization", basicAuth);


            InputStream stream = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder builder = new StringBuilder();

            String inputString;
            while ((inputString = bufferedReader.readLine()) != null) {
                builder.append(inputString);
            }

            int responsecode = urlConnection.getResponseCode();
            Log.d("ResponseCode", String.valueOf(responsecode));
            if(responsecode == 200){

                try {
                    JSONArray jsonArray = new JSONArray(builder.toString());
                    final int numberOfItemsInResp = jsonArray.length();
                    for (int i = 0;  i < numberOfItemsInResp; i++) {
                        JSONObject jobj = jsonArray.getJSONObject(i);
                        String name = jobj.getString("NAME");
                        String latitude = jobj.getString("LATITUDE");
                        String longitude = jobj.getString("LONGITUDE");

                        LatLng latLng = new LatLng(Double.valueOf(addlatitude), Double.valueOf(addlongitude));
                        allLocations.add(new Pair<>(name, latLng))
                    }
                } catch (JSONException e) {
                    Log.e("JSON Parser", "Error parsing data " + e.toString());
                }

            }
            urlConnection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allLocations;
    }

    @Override
    protected void onPostExecute(List<Pair<String, LatLng>> locations) {
        for (Pair<String, LatLng> location : locations) {
            mMap.addMarker(new MarkerOptions().position(location.second).title("UserName: " + location.first));
        }
    }
}