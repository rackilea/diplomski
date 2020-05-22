for (int i = 0; i < recs.length(); ++i) {
    JSONObject rec = recs.getJSONObject(i);
    int id = rec.getInt("id");
    String loc = rec.getString("loc");
    // ...
}