List<LatLng> coordinates = new ArrayList<>();
try {
    JSONArray jsonArray = new JSONArray(latlan);
    for (int i = 0; i < jsonArray.length(); i++) {
        JSONArray latLong = jsonArray.getJSONArray(i);
        double lat = latLong.getDouble(0);
        double lon = latLong.getDouble(1);
        coordinates.add(new LatLng(lat, lon));
    }
} catch (JSONException e) {
    e.printStackTrace();
}

System.err.println(Arrays.toString(coordinates.toArray()));

for (LatLng latLng : coordinates) {
    //use the coordinates.
}