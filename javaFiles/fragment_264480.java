public JSONObject readJsonFromUrl(String JSONurl) throws IOException, JSONException {
    URL url = new URL(JSONurl);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("POST");
    conn.setRequestProprtry("Content-type", "application/JSON");
    try {
        BufferedReader bufferedReader = new BufferedReader(conn. getInputStream());
        String jsonText = read(bufferedReader);
        JSONObject json = new JSONObject(jsonText);
        return json;
    } finally {
        url.close();
    }
}