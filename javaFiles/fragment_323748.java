JSONObject resultObject = new JSONObject(result);
JSONObject responseObject = resultObject.getJSONObject("response");
JSONArray artistArray = responseObject.getJSONArray("artists");
for (int i = 0; i < artistArray.length(); i++) {
   JSONObject artist = artistArray.getJSONObject(i);
   String name = artist.getString("name");
   // generate button 
}