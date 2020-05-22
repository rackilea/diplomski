CredentialsProvider provider = new BasicCredentialsProvider();
UsernamePasswordCredentials creds = 
    new UsernamePasswordCredentials("username", "password");
provider.setCredentials(AuthScope.ANY, creds);

CloseableHttpAsyncClient httpclient = HttpAsyncClients.custom()
            .setDefaultRequestConfig(requestConfig)
            .setDefaultCredentialsProvider(provider)
            .build();