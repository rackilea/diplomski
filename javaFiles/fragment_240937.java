CredentialsProvider credsProvider = new BasicCredentialsProvider();
credsProvider.setCredentials(
    new AuthScope("somehost", AuthScope.ANY_PORT), 
    new UsernamePasswordCredentials("username", "password"));

HttpClient httpclient = new DefaultHttpClient();
httpclient.setCredentialsProvider(credsProvider);