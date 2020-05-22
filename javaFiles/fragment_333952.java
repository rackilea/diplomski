CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
HttpClient httpClient = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();

credentialsProvider.setCredentials(AuthScope.ANY, new NTCredentials("Username", "Password", null, "Domain"));