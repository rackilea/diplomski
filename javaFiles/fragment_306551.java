String stat1;
String stat2;
String stat3;
JSONObject ret; //contains the original response
//Parse to get the value
try {
    stat1 = ret.getJSONArray("results").getJSONObject(0).getString("status");
    stat2 = ret.getJSONArray("results").getJSONObject(1).getString("status");
    stat3 = ret.getJSONArray("results").getJSONObject(2).getString("status");
} catch (JSONException e1) {
    e1.printStackTrace();

}