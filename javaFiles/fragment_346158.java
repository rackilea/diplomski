JSONObject rootJson = new JSONObject(jsonString);
JSONArray jsonArray = rootJson.getJSONArray("GetLocationsResult");

//Let's assume we need names....
String[] names = null;
if (jsonArray != null) {
    names = new String[jsonArray.length()];
    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject json = jsonArray.getJSONObject(i);
        names[i] = json.getString("Name");
    }
}

//Test
for (String name: names) {
    System.out.println(name);
}