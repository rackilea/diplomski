public static String hashMapToJsonString(HashMap hashMap){
    JsonObject json = hashMapToJsonObject(hashMap);
    return new json.toJson();
}

public static HashMap<String, Object> jsonStringToHashMap(String string) {
    JsonObject json = Json.parse(string.getRawString());
    HashMap<String, Object> retMap = new HashMap<String, Object>();
    if (!(json instanceof JreJsonNull)) {
        retMap = jsonObjectToHashMap(json);
    }
    return retMap;
}

private static JsonObject hashMapToJsonObject(HashMap hashMap) {
    JsonObject json = Json.createObject();
    Set<String> keySet = hashMap.keySet();
    for(String key : keySet){
        Object object = hashMap.get(key);
        if(object instanceof ArrayList){
            json.put(key, arrayListToJsonArray((ArrayList)object));
        } else if(object instanceof HashMap){
            json.put(key, hashMapToJsonObject((HashMap)object));
        } else if(object instanceof String) {
            json.put(key, (String)object);
        } else {
            throw new RuntimeException("Type not catered for java->json conversion (in HashMap): " + object.getClass().getName());
        }
    }
    return json;
}

private static JsonArray arrayListToJsonArray(ArrayList array) {
    JsonArray json = Json.createArray();
    int i = 0;
    for(Object object : array){
        if(object instanceof ArrayList) {
            json.set(i, arrayListToJsonArray((ArrayList)object));
        } else if(object instanceof HashMap) {
            json.set(i, hashMapToJsonObject((HashMap)object));
        } else if(object instanceof String) {
            json.set(i, (String)object);
        } else {
            throw new RuntimeException("Type not catered for java->json conversion (in array): " + object.getClass().getName());
        }
        i ++;
    }
    return json;
}

private static HashMap<String, Object> jsonObjectToHashMap(JsonObject json) throws JsonException {
    HashMap<String, Object> map = new HashMap<String, Object>();
    String[] keys = json.keys();
    for(String key : keys){
        Object object = json.get(key);
        map.put(key, jsonObjectToJavaObject(object));
    }
    return map;
}

private static ArrayList jsonArrayToArrayList(JsonArray json) throws JsonException {
    ArrayList array = new ArrayList();
    for(int i = 0; i < json.length(); i++) {
        Object object = json.get(i);
        array.add(jsonObjectToJavaObject(object));
    }
    return array;
}

private static Object jsonObjectToJavaObject(Object jsonObject) {
    if(jsonObject instanceof JsonArray) {
        return jsonArrayToArrayList((JsonArray) jsonObject);
    } else if(jsonObject instanceof JsonObject) {
        return jsonObjectToHashMap((JsonObject) jsonObject);
    } else if(jsonObject instanceof JreJsonString) {
        return ((JreJsonString)jsonObject).asString();
    } else if(jsonObject instanceof JreJsonNumber) {
        return new Double(((JreJsonNumber)jsonObject).asNumber());
    } else if(jsonObject instanceof JreJsonNull){
        return new Null();
    } else {
        throw new RuntimeException("Type not catered for json->java conversion: " + jsonObject.getClass().getName());
    }
}