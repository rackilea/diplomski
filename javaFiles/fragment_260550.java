List<Comment> fetchComments() {
    Log.d("running", "attempting fetch...");
    String raw = RemoteData.readContents(url);
    List<Comment> list = new ArrayList<Comment>();
    try {
        JSONObject data = new JSONArray(raw).getJSONObject(1);
        JSONArray children = data.getJSONObject("data").getJSONArray("children");
        Log.d("running", "comments: " + children.length());
        }
    } catch (Exception e) {
        Log.e("fetchComments()", e.toString());
    }
    return list;
}