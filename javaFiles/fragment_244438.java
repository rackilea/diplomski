public static JSONObject objectToJSONObject(Object object){
    Object json = null;
    JSONObject jsonObject = null;
    try {
        json = new JSONTokener(object.toString()).nextValue();
    } catch (JSONException e) {
        e.printStackTrace();
    }
    if (json instanceof JSONObject) {
        jsonObject = (JSONObject) json;
    }
    return jsonObject;
}

public static JSONArray objectToJSONArray(Object object){
    Object json = null;
    JSONArray jsonArray = null;
    try {
        json = new JSONTokener(object.toString()).nextValue();
    } catch (JSONException e) {
        e.printStackTrace();
    }
    if (json instanceof JSONArray) {
        jsonArray = (JSONArray) json;
    }
    return jsonArray;
}