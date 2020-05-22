JSONObject object = new JSONObject("{\"items\": [{\"name\":\"TF_WEAPON_BAT\"}, {\"name\":\"TF_WEAPON_BAT\"}]}");

JSONArray array = object.getJSONArray("items");
for (int i = 0; i < array.length(); i++) {
    String name = array.getJSONObject(i).getString("name");
    if ("TF_WEAPON_BAT".equals(name)) {
        // do something
        JSONObject foundItem = array.getJSONObject(i); // this holds the object that had a matching name element
        // you can add it to some other list
    }
}