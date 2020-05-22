public JSONObject append(String key, Object value) throws JSONException {
    testValidity(value);
    Object o = opt(key);
    if (o == null) {
        put(key, new JSONArray().put(value));
    } else if (!(o instanceof JSONArray)){
        throw new JSONException("JSONObject[" + key + "] is not a JSONArray.");
    } else {
        put(key, new JSONArray().put(o).put(value));
    }
    return this;
}