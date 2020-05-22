public JSONObject getJsonData() {
    JSONObject params = new JSONObject();
    try {
        params.put("departure_time", "2016-07-21 07:00:00");
        params.put("arrival_time", "2016-07-21 08:30:00");
        params.put("mode", "driving");
        JSONArray address = new JSONArray();
        address.put("Milpitas+ca");
        address.put("SanCarlos+Ca");
        params.put("location_flow", address);

        JSONArray buffer_time = new JSONArray();
        buffer_time.put(0);
        buffer_time.put(30);
        buffer_time.put(0);
        params.put("buffer_time", buffer_time);
    } catch (JSONException e) {
        e.printStackTrace();
    }
    return params;
}