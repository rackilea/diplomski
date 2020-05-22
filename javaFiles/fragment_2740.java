JSONObject obj = new JSONObject(...);
JSONArray matches = obj.optJSONArray("matches");
if (matches != null) {
 for (int i = 0; i < matchesLenght; i++) {
    JSONObject objAtIndex =  matches.optJSONObject(i);
    if (objAtIndex != null) {
         JSONArray smallImageUrls = objAtIndex.optJSONArray("smallImageUrls");
         for (int j = 0; j < smallImageUrlsSize; j++) {
              String urlAtIndex = smallImageUrls.optString(j);
         }
    }
 }

}