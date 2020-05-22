public static JSONArray getJsonArraysOfNames(List<String> names) {
    JSONArray jsonArray = new JSONArray();
    for (String name : names) {
        JSONObject object = new JSONObject();
        object.put("name", name);
        jsonArray.put(object);
    }

    return jsonArray;
}