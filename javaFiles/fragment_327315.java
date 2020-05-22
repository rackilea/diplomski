public boolean transformToJSON(String source) {
  boolean success = true;
  try {
    JSONObject js = new JSONObject(new JSONTokener(item.getHtml()));
  }
  catch (JSONException e) {
    log(e)
    success = false;
  }
  //than js is added to an Hashset and the method is done
  return success;
}