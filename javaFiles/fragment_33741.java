HttpHost proxy = new HttpHost("127.0.0.1", 8080, "http");

    DefaultHttpClient httpclient = new DefaultHttpClient();
    try {
        httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

        HttpHost target = new HttpHost("issues.apache.org", 443, "https");
        HttpGet req = new HttpGet("/");

        System.out.println("executing request to " + target + " via " + proxy);
        HttpResponse rsp = httpclient.execute(target, req);
        ...
    } finally {
        // When HttpClient instance is no longer needed,
        // shut down the connection manager to ensure
        // immediate deallocation of all system resources
        httpclient.getConnectionManager().shutdown();
    }