class getEmbassyPoint extends AsyncTask<LatLng, String, ArrayList<CustomObject>> {

    double x, y;
    String name;

    private LatLng myPoint;


    @Override
    protected ArrayList<CustomObject> doInBackground(LatLng... params) {



        myPoint = params[0];

        String s = "https://maps.googleapis.com/maps/api/place/nearbysearch" + "/json?location=" + myPoint.latitude + "," + myPoint.longitude
                + "&radius=50000&types=embassy&name=ireland" + "&key=my api key";



        try {
            URL url = new URL(s);
            BufferedReader r = new BufferedReader(new InputStreamReader(((HttpURLConnection) url.openConnection()).getInputStream()));
            JsonParser jp = new JsonParser();
            JsonElement jsonElement = jp.parse(r);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonArray jsonArray = jsonObject.getAsJsonArray("results");


            List<CustomObject> listt = new ArrayList<>();


            for (JsonElement element : jsonArray) {



                name = element.getAsJsonObject().get("name").getAsString();

                x = Double.valueOf(element.getAsJsonObject().get("geometry").getAsJsonObject().get("location").getAsJsonObject().get("lat").getAsString());
                y = Double.valueOf(element.getAsJsonObject().get("geometry").getAsJsonObject().get("location").getAsJsonObject().get("lng").getAsString());

                CustomObject customObject = new CustomObject;
                customObject.title = element.getAsJsonObject().get("name").getAsString();
                customObject.latLng = new LatLng(x,y);
                listt.add(customObject);

            }

            return  (ArrayList<CustomObject>) listt;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(ArrayList<CustomObject> latLngs) {
        super.onPostExecute(latLngs);

        List<Marker> markers = new ArrayList<Marker>();

        for (CustomObject latLng : latLngs){

            Marker marker = mMap.addMarker(new MarkerOptions().position(latLng.latLng).title(latLng.title).icon(BitmapDescriptorFactory.fromResource(R.drawable.mosque)));
            markers.add(marker);
            MarkerOptions mp = new MarkerOptions();
            mp.title(latLng.title);

        }

    }

}