DefaultHttpClient httpclient = new DefaultHttpClient();
HttpHost proxy = new HttpHost("myproxy.com", 9191);
httpclient.getCredentialsProvider().setCredentials(
  new AuthScope(PROXY, PROXY_PORT),
  new UsernamePasswordCredentials("username", "password"));
httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);