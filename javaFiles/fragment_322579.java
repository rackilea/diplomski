JSONObject root = new JSONObject(yourJsonString);
JSONArray sportsArray = root.getJSONArray("sport");
// now get the first element:
JSONObject firstSport = sportsArray.getJSONObject(0);
// and so on
String name = firstSport.getString("name"); // basketball
int id = firstSport.getInt("id"); // 40
JSONArray leaguesArray = firstSport.getJSONArray("leagues");

// and so on, you can process leaguesArrays similarily