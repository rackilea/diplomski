JSONObject history = obj.getJSONObject("history");
for (String date: history.keySet()) {
  JSONObject post = history.getJSONObject(date);
  String postId = post.getString("op");
  // ...
}