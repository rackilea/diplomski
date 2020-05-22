GetMethod httpget = new GetMethod("http://www.url.com/");
  try {
    httpclient.executeMethod(httpget);
    Reader reader = new InputStreamReader(httpget.getResponseBodyAsStream(), httpget.getResponseCharSet()); 
    // consume the response entity and do something awesome
  } finally {
    httpget.releaseConnection();
  }