public String POST(String url, JSONObject jsonObject) {
    InputStream inputStream = null;
    String result = "";
    try {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        String json = "";
        json = jsonObject.toString();
        StringEntity se = new StringEntity(json);
        httpPost.setEntity(se);
        httpPost.setHeader("Content-type", "application/json");
        HttpResponse httpResponse = httpclient.execute(httpPost);
        inputStream = httpResponse.getEntity().getContent();
        if (inputStream != null)
            result = convertInputStreamToString(inputStream);
        else
            result = "Did not work!";
    } catch (Exception e) {
        Log.d("InputStream", e.getLocalizedMessage());
    }

    return result;
}

private static String convertInputStreamToString(InputStream inputStream) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    String line = "";
    String result = "";
    while ((line = bufferedReader.readLine()) != null)
        result += line;

    inputStream.close();
    return result;

}