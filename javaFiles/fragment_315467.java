DefaultHttpClient httpclient = new DefaultHttpClient();
httpclient.getCredentialsProvider().setCredentials(
    new AuthScope("PROXY HOST", 8080),
    new UsernamePasswordCredentials("username", "password"));

HttpHost targetHost = new HttpHost("TARGET HOST", 443, "https");
HttpHost proxy = new HttpHost("PROXY HOST", 8080);

httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);