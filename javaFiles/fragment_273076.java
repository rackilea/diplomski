@Override
protected Void doInBackground(Void... params) {
    try {
        String jsonString = Jsoup.connect(url).execute().body();
        JSONObject json = new JSONObject(jsonString);
        JSONArray list = json.getJSONObject("list").getJSONArray("item");
        // now you can use the list
    } catch (JSONException | IOException e) {
        e.printStackTrace();
    }
    return null;
}