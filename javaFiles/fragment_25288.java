String json = "{
  "a": 11,
  "b": 22,
  "object": {
    "c": 33,
    "d": 44,
    "e": 55
  }
}";


JSONObject jObj = new JSONObject(json);
JSONObject jObjNew = new JSONObject();
multiToLinearJson(jObj);


public void multiToLinearJson(JSONObject jObj) {
    Iterator<String> iter = jObj.keys();
    while (iter.hasNext()) {
        String key = iter.next();
        try {
            Object value = jObj.get(key);
            if (value instanceof JSONObject) {
                multiToLinearJson(value);
            }
            jObjNew.put(key, value);
        } catch (JSONException e) {
            // Something went wrong!
        }
    }
}