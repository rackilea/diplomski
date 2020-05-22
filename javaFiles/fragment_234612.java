public XXX parseYourString(String json) {
    XXX xxx = new XXX();
    try {
          JSONArray arr = JSONArray.fromObject(json);

          // do something with arr

    } catch (JSONException ex) {
        return null;
    }
    return xxx;
}