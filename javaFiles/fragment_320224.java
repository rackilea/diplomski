PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(18);
        cm.setDefaultMaxPerRoute(6);

        RequestConfig requestConfig = RequestConfig.custom()
        .setSocketTimeout(30000)
        .setConnectTimeout(30000)
        .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM))
        .setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC))
        .build();

        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new NTCredentials(userName, password, hostName, domainName));

        // Finally we instantiate the client. Client is a thread safe object and can be used by several threads at the same time. 
        // Client can be used for several request. The life span of the client must be equal to the life span of this EJB.
         this.httpclient = HttpClients.custom()
        .setConnectionManager(cm)
        .setDefaultCredentialsProvider(credentialsProvider)
        .setDefaultRequestConfig(requestConfig)
        .build();