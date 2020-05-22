CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
HttpHost proxy = new HttpHost("proxy.com", 8080, "http");
credentialsProvider.setCredentials(new AuthScope(proxy),
    new UsernamePasswordCredentials("usrname", "passwrd"));
credentialsProvider.setCredentials(new AuthScope("api.com", AuthScope.ANY_PORT),
    new UsernamePasswordCredentials("apiuser", "apipassword"));