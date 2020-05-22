if (jsonStr != null) {
    try {
        JSONArray json = new JSONArray(jsonStr);
        for (int i=0; i < json.length(); i++) {
            Log.d("JSON PARSE", json.getJSONObject(i).getString("name"));
        }
    } catch (JSONException e) {
        Log.w("JSON PARSE", "Failed to parse JSON!", e);
    }
}