protected JSONObject doInBackground(String... args) {
    JSONObject json = new JSONObject();
    try {
        Intent in = getIntent();
        String searchTerm = in.getStringExtra("TAG_SEARCH");
        String query = URLEncoder.encode(searchTerm, "utf-8");
        String URL = "http://example.com";
        JSONParsser jParser = new JSONParsser();

        try {
            json = jParser.readJSONFeed(URL);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return json;           

}