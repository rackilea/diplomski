@Override
protected String doInBackground(String... params) {
    HttpHost targetHost = new HttpHost(BASE_URL,443,"https");
    CredentialsProvider credsProvider = new BasicCredentialsProvider();
    credsProvider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials(DEFAULT_USER,DEFAUL_PASSWORD));

    AuthCache authCache = new BasicAuthCache();
    authCache.put(targetHost,new BasicScheme());

    final HttpClientContext context = HttpClientContext.create();
    context.setCredentialsProvider(credsProvider);
    context.setAuthCache(authCache);

    SSLContext sslContext = SSLContexts.createSystemDefault();
    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);

    HttpClient client = HttpClientBuilder.create().setSSLSocketFactory(sslsf).build();
    try {
        HttpResponse response = client.execute(new HttpGet(BASE_URL), context);
        String json_string = EntityUtils.toString(response.getEntity());
        Log.i("JSON", json_string);
        int statusCode = response.getStatusLine().getStatusCode();
        Log.i("RESP",response.getEntity().getContent().toString());

        Log.i("STATUS", "" + statusCode);
        return response.toString();

    }catch(Exception e){
        e.printStackTrace();
    }
    return "";
}