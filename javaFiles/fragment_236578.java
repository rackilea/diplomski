public JSONArray getJSONFromUrl(String url) {
    ....
    static JSONArray jsonArray = null;
    ....
     // Parsing the string to a JSON Array
     try {
            jsonArray = new JSONArray(json);
     } catch (JSONException exception) {
            exception.printStackTrace();
     }
     return jsonArray;
  }