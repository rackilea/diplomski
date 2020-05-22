ArrayList<JSONArray> staffArray = new ArrayList<>();

Set<String> ids = new HashSet<>();
for (JSONArray array : staffArray) {
    for (int i = 0; i < array.length(); i++) {
        JSONObject obj = array.getJSONObject(i);
        if (!ids.add(obj.getString("id"))) {
            // duplicate IDs found, do something
        }
    }
}