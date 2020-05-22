public byte[] fetchURL(String url) throws IOException, ClientProtocolException {
      HttpClient httpclient = new DefaultHttpClient();
      HttpGet httpget = new HttpGet(url);
      HttpResponse response = httpclient.execute(httpget);
      HttpEntity entity = response.getEntity();
      return EntityUtils.toByteArray(entity);
}