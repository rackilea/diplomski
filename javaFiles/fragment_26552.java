JSONArray array = new JSONArray(jsonString);

for(int i = 0; i < array.length(); i++) {
    JSONObject obj = array.getJSONObject(i);
    JSONObject innerObject = obj.getJSONObject("news");

    String title = innerObject.getString("title");
    String content = innerObject.getString("content");
    String date = innerObject.getString("date");

    /* Use your title, content, and date variables here */
}