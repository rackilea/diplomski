JSONObject jObj;
JSONObject tracks;
JSONArray items;
String id;

jObj = new JSONObject(json);    // json is the JSON string
tracks = (JSONObject) jObj.get("tracks");
items = (JSONArray) tracks.get("items");
id = items.getJSONObject(9).getString("id");