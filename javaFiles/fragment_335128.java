CredentialsProvider credsProvider = new BasicCredentialsProvider();

AuthScope siteScope = new AuthScope(siteHost, sitePort);
Credentials siteCreds = new UsernamePasswordCredentials(siteUsername, sitePassword);
credsProvider.setCredentials(siteScope, siteCreds);

AuthScope proxyScope = new AuthScope(proxyHost, proxyPort);
Credentials proxyCreds = new UsernamePasswordCredentials(proxyUsername, proxyPassword);
credsProvider.setCredentials(proxyScope, proxyCreds);