@Override
public void onMapReady(GoogleMap googleMap) {
    mMapSnailTrail = googleMap;
    // Remove asynctask since you are already using retrofit enqueue
    // new GetSnailTrail().execute();
    //Create a new method to call api using retrofit
    getDataFromServer();
    mMapSnailTrail.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(12.405888, 123.273419), 6));
}

private void getDataFromServer() {

    /**
    *Show Progress dialog here      
    */

    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    httpClient.addInterceptor(logging);
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build();

    networkAPI = retrofit.create(NetworkAPI.class);

    SnailTrailPojo loginRequest = new SnailTrailPojo(vm.getPlate_num(), /*"08/03/2017 00:00:00"*/ BottomSheetModalFragment.dateFrom, "08/04/2017 23:59:59", client_table);

    System.out.println(vm.getPlate_num() + client_table + BottomSheetModalFragment.dateFrom + " asdas");

    Call<JsonElement> call = networkAPI.loginRequest(loginRequest);

    call.enqueue(new Callback<JsonElement>() {
        @Override
        public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
            // success response

           /**
           * Hide the progress dialog here
           */

            if (response.body().isJsonArray()) {
                JsonArray objectWhichYouNeed = response.body().getAsJsonArray();
                //                    System.out.println(response.body() + " "+ "Response");

                list_location = new ArrayList<>();
                for (int i = 0; i < response.body().getAsJsonArray().size(); i++) {

                    JsonElement location_array = response.body().getAsJsonArray().get(i);
                    JsonObject location_obj = location_array.getAsJsonObject();
                    String location = location_obj.get("location").toString();

                    JsonElement lat_array = response.body().getAsJsonArray().get(i);
                    JsonObject lat_obj = lat_array.getAsJsonObject();
                    String lati = lat_obj.get("lat").toString();
                    String latiString = lati;
                    latiString = latiString.replace("\"", "");
                    String lat = String.valueOf(latiString);

                    JsonElement lng_array = response.body().getAsJsonArray().get(i);
                    JsonObject lng_obj = lng_array.getAsJsonObject();
                    String longi = lng_obj.get("lng").toString();
                    String longiString = longi;
                    longiString = longiString.replace("\"", "");
                    String lng = String.valueOf(longiString);

                    JsonElement remarks_array = response.body().getAsJsonArray().get(i);
                    JsonObject remarks_obj = remarks_array.getAsJsonObject();
                    String remarks = remarks_obj.get("remarks").toString();
                    if (lat != null && !lat.equals("null") && (lng != null && !lng.equals("null"))) {
                        list_location.add(new LocationHolder(lat, lng, location, remarks));
                    }



                    SharedPreferences preferences = context.getSharedPreferences("AppPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor prefsEditor = preferences.edit();

                    Gson gson = new Gson();

                    String jsonText = gson.toJson(list_location);
                    prefsEditor.putString("key", jsonText);
                    prefsEditor.commit();


                    //Move the on postExecute code here

                    final PolylineOptions polylineOptions = new PolylineOptions();
                    for (int j = 0; j < list_location.size(); j++) {

                        // Setting the color of the polyline
                        polylineOptions.color(Color.RED);

                        // Setting the width of the polyline
                        polylineOptions.width(3);

                        Double d1 = Double.parseDouble(list_location.get(j).getLatitude());
                        Double d2 = Double.parseDouble(list_location.get(j).getLongitude());

                        Toast.makeText(getContext(), d1 + d2.toString(),Toast.LENGTH_LONG).show();
                        // Setting points of polyline
                        polylineOptions.add(new LatLng(d1, d2));

                        createMarker(j, d1, d2, list_location.get(j).getRemarks());

                    }
                    // Adding the polyline to the map
                    mMapSnailTrail.addPolyline(polylineOptions);

                }

            } else {
                System.out.println("Not a JSONArray.");
            }
        }

        @Override
        public void onFailure(Call<JsonElement> call, Throwable t) {
            // failure response
            System.out.println("Fail " + call.toString());
        }

    });
}