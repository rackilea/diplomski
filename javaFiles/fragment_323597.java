HttpHost proxy = new HttpHost(PROXY_URL, 8080);
DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);

AuthCache authCache = new BasicAuthCache();
CredentialsProvider credsProvider = new BasicCredentialsProvider();
credsProvider.setCredentials(new AuthScope(PROXY_URL, 8080, AuthScope.ANY_HOST, "ntlm"), new NTCredentials(authUser, authPassword, "",PROXY_DOMAIN));
HttpClientContext context = HttpClientContext.create();
context.setCredentialsProvider(credsProvider);
context.setAuthCache(authCache);

httpClient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).setRoutePlanner(routePlanner).build();