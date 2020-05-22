static String response = null;

    public static String readContents(String url) {
      try {
        // http client
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpEntity httpEntity = null;
        HttpResponse httpResponse = null;
        HttpGet httpGet = new HttpGet(url);
        httpResponse = httpClient.execute(httpGet);
        httpEntity = httpResponse.getEntity();
        response = EntityUtils.toString(httpEntity);
      } catch (IOException e) {
        Log.d("READ FAILED", e.toString());
        return null;
      }
      return response;
    }