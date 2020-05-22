JSONArray getArrayOrObject(JSONObject parent, String name) {
    JSONArray results = parent.optJSONArray(name);
    if (results == null) {
      results = new JSONArray();
      JSONObject object = parent.optJSONObject("Result");
      if (object != null) {
        results.put(object);
      }
    }
    return results;
  }