RequestConfig defaultRequestConfig = RequestConfig.custom()
    .setCookieSpec(CookieSpecs.BEST_MATCH)
    .setExpectContinueEnabled(true)
    .setStaleConnectionCheckEnabled(true)
    .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
    .setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC))
    .build();

HttpGet httpGet = new HttpGet(url);    
RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig)
    .setSocketTimeout(5000)
    .setConnectTimeout(5000)
    .setConnectionRequestTimeout(5000)
    .build();
httpGet.setConfig(requestConfig);