class GetDirections extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... params) {
            String startAddress =  params[0];
            startAddress = startAddress.replaceAll(" ", "%20");
            getLatLng(startAddress, false);

            String endingAddress = params[1];
            endingAddress = endingAddress.replaceAll(" ", "%20");
            getLatLng(endingAddress, true);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            String geoUriString = "http://maps.google.com/maps?addr=" +
                    addressPos.latitude + "," +
                    addressPos.longitude + "&daddr=" +
                    finalAddressPos.latitude + "," +
                    finalAddressPos.longitude;

            Intent mapCall = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUriString));
            startActivity(mapCall);
        }
    }

    protected void getLatLng(String address, boolean setDestination) {
        String uri = "http://maps.google.com/maps/api/geocode/json?address="
                + address + "&sensor=false";

        HttpGet httpGet = new HttpGet(uri);

        HttpClient client = new DefaultHttpClient();
        HttpResponse response;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();

            InputStream stream = entity.getContent();

            int byteData;
            while ((byteData = stream.read()) != -1) {
                stringBuilder.append((char) byteData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        double lat = 0.0, lng = 0.0;

        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(stringBuilder.toString());
            lng = ((JSONArray) jsonObject.get("results")).getJSONObject(0)
                    .getJSONObject("geometry").getJSONObject("location")
                    .getDouble("lng");
            lat = ((JSONArray) jsonObject.get("results")).getJSONObject(0)
                    .getJSONObject("geometry").getJSONObject("location")
                    .getDouble("lat");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (setDestination) {
            finalAddressPos = new LatLng(lat, lng);
        } else {
            addressPos = new LatLng(lat, lng);
        }

    }