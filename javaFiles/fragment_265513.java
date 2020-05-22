HttpParams params = new BasicHttpParams();

  // ....

  HttpHost proxy = new HttpHost("192.168.1.12", 8888); // IP to your PC with fiddler proxy
  params.setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

  // use params as a second parameter to: following constructor:
  // public DefaultHttpClient (ClientConnectionManager conman, HttpParams params)