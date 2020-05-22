public static InputStream getInputStreamFromUrl(String url) {
  InputStream content = null;
  try {
    HttpClient httpclient = new DefaultHttpClient();
    HttpResponse response = httpclient.execute(new HttpGet(url));
    content = response.getEntity().getContent(); 
  } catch (Exception e) {
    Log.("[GET REQUEST]", "Network exception", e);
  }
    return content; //url content is here.
}