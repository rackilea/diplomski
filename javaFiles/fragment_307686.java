JSONObject ret = getLocationInfo(); 
JSONObject location;
String location_string;
try {
    location = ret.getJSONArray("results").getJSONObject(0);
    location_string = location.getString("formatted_address");
    Log.d("test", "formattted address:" + location_string);
} catch (JSONException e1) {
    e1.printStackTrace();

}