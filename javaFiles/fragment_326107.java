public static Collection<String> getAllNames(JSONArray jsonArray, List<String> names) {
    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject object = jsonArray.getJSONObject(i);
        names.add(object.getString("name"));
        if (object.has("children")) {
            JSONArray children = object.getJSONArray("children");
            getAllNames(children, names);
        }
    }

    return names;
}