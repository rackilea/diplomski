HttpClient httpclient = new HttpClient();
  httpclient.getHostConfiguration().setProxy("myproxyhost", 8080);
  httpclient.getState().setProxyCredentials("my-proxy-realm", " myproxyhost",
  new UsernamePasswordCredentials("my-proxy-username", "my-proxy-password"));
  GetMethod httpget = new GetMethod("https://www.verisign.com/");
  try { 
    httpclient.executeMethod(httpget);
    System.out.println(httpget.getStatusLine());
  } finally {
    httpget.releaseConnection();
  }