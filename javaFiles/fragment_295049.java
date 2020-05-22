for (int i = 0, len = jsonArr.length(); i < len; i++) {
    JSONObject obj = jsonArr.getJSONObject(i);
    // Do your removals
    obj.remove("id");
    // etc.
}