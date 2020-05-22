//@Override
protected List<DublinBusObject> doInBackground(String... params) {
    String liveUpdateUrl = params[0];
    List<DublinBusObject> dublinBusObjects = new ArrayList<>();
    try {

        //Use JSONParser to download the JSON
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = jsonParser.makeHttpRequest(
                liveUpdateUrl, "GET", new HashMap<String, String>());

        JSONArray jsonArray= jsonObject.getJSONArray("stops");
        for (int x = 0; x < jsonArray.length(); x++) {

            JSONObject jsonItem = jsonArray.getJSONObject(x);

            this.busRoute = jsonItem.getString("bus_num");
            this.busDescription = jsonItem.getString("description");
            this.bueTime = jsonItem.getString("exected_dep");
            this.busStopId = jsonItem.getString("stop_id");

            DublinBusObject dublinBusObject = new DublinBusObject(busRoute, busDescription, bueTime, busStopId);
            dublinBusObjects.add(dublinBusObject);
        }

    } catch (JSONException e) {
        e.printStackTrace();
    }
    return dublinBusObjects;
}