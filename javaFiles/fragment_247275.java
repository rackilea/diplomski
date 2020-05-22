public JSONObject getPostResult(String json){
    if(!json.isEmpty()) {
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON_ERROR", "Error parsing data " + e.toString());
        }
    }
    return jObj;
}