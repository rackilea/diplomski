JSONObject series = new JSONObject();
JSONArray $_time = new JSONArray();
JSONArray msrVal = new JSONArray();
JSONArray unitVal = new JSONArray();
JSONObject msr = new JSONObject();

for (int i=0; i<ts.length; i++) {
    $_time.clear();
    msrVal.clear();
    unitVal.clear();
    ...
    measurements.add(msr);
}