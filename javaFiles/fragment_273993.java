JSONObject obj=new JSONObject(jsonString);

JSONObject responseJson=obj.getJSONObject("responseData");
JSONObject feedjson=responseJson.getJSONObject("feed");
JSONArray entriesJSON=feedjson.getJSONArray("entries");
 for (int i = 0; i < entriesJSON.length(); i++) {
  ...
   ..
 }