public static List parseList(String jsonInput, Class clazz) {
    List result = new LinkedList();
    JSONArray json = (JSONArray) JSONSerializer.toJSON(jsonInput);
    JSONObject items = (JSONObject)json.getJSONObject(0);
    JSONArray dataArrayJSON = (JSONArray)items.getJSONArray("items");

    for (int i = 0; i < dataArrayJSON.size(); i++) {
        result.add(JSONObject.toBean(dataArrayJSON.getJSONObject(i).getJSONObject("item"), clazz));
    }
    return result;
}