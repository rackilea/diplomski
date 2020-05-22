public static JSONObject readJSONFeed(String URL, String username,
        String password) throws KeyManagementException,
        UnrecoverableKeyException, NoSuchAlgorithmException,
        KeyStoreException, ClientProtocolException, IOException {

    String auth = username + ":" + password;
    HttpClient httpClient = = new DefaultHttpClient;

    StringBuilder stringBuilder = new StringBuilder();

    // Build HTTP request
    HttpPost httpPost = new HttpPost(URL);
    httpPost.setHeader(
            "Authorization",
            "Basic "
                    + Base64.encodeToString(auth.getBytes(), Base64.NO_WRAP));
    httpPost.setHeader("Accept", "application/json");

    // send the request
    HttpResponse response = httpClient.execute(httpPost);

    // read the result
    StatusLine statusLine = response.getStatusLine();
    int statusCode = statusLine.getStatusCode();
    if (statusCode == 200) {
        HttpEntity entity = response.getEntity();
        InputStream inputStream = entity.getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        inputStream.close();
    } else if (statusCode == 401) {
        throw new IOException("Authentication failed");
    } else {
        throw new IOException(statusLine.getStatusCode() + ":"
                + statusLine.getReasonPhrase());
    }

    // Return the JSON Object
    return new JSONObject(stringBuilder.toString());
}