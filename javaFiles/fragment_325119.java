public static Map<String,Object> parseJSONObjectToMap(JSONObject jsonObject) throws JSONException{
    Map<String, Object> mapData = new HashMap<String, Object>();
    Iterator<String> keysItr = jsonObject.keys();
        while(keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = jsonObject.get(key);

            if(value instanceof JSONArray) {
                value = parseJSONArrayToList((JSONArray) value);
            }else if(value instanceof JSONObject) {
                value = parseJSONObjectToMap((JSONObject) value);
            }
            mapData.put(key, value);
        }
    return mapData;
}

public static List<Object> parseJSONArrayToList(JSONArray array) throws JSONException {
    List<Object> list = new ArrayList<Object>();
    for(int i = 0; i < array.length(); i++) {
        Object value = array.get(i);
        if(value instanceof JSONArray) {
            value = parseJSONArrayToList((JSONArray) value);
        }else if(value instanceof JSONObject) {
            value = parseJSONObjectToMap((JSONObject) value);
        }
        list.add(value);
    }
    return list;
}