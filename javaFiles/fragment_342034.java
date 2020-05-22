HttpHost proxyhost = new HttpHost(host,pw);

CredentialsProvider credsProvider = new BasicCredentialsProvider();

credsProvider.setCredentials(new AuthScope(proxyhost), new UsernamePasswordCredentials(user, pw));
clientConfig.property(ApacheClientProperties.CREDENTIALS_PROVIDER, credsProvider);

builder.setProxy(proxyhost);