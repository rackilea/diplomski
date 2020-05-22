JSONObject object = new JSONObject(YOUR RESPONSE STRING);

JSONArray jArray = object.getJSONArray("latlong");

for (int i = 0; i < jArray.length(); i++)
{
    String lat = jArray.getJSONObject(i).getString("lat");
    String lon = jArray.getJSONObject(i).getString("lon");

}