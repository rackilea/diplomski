JSONObject o = new JSONObject(s);
JSONArray a = o.getJSONArray("posts");
int arrSize = a.length();
List<Integer> lat = new ArrayList<Integer>(arrSize);
List<Integer> lon = new ArrayList<Integer>(arrSize);
for (int i = 0; i < arrSize; ++i) {
    o = a.getJSONObject(i);
    lat.add((int) (o.getDouble("Latitude")* 1E6));
    lon.add((int) (o.getDouble("lontitude")* 1E6));
}