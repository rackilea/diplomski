httpPost.setHeader(HttpHeaders.ACCEPT, "application/json");
    httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
    httpPost.setHeader(HttpHeaders.AUTHORIZATION, authHeaderValue);

    httpPost.setHeader(HttpHeaders.ACCEPT_ENCODING, "gzip,deflate");
    httpPost.setHeader(HttpHeaders.ACCEPT_LANGUAGE, "en-US");
    httpPost.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
    httpPost.setHeader(HttpHeaders.CONNECTION, "keep-alive");
    //httpPost.setHeader(HttpHeaders.HOST, LYNC_EXT_POOL_HOST); <= Was the bad guy
    //httpPost.setHeader(X_MS_ORIGIN_HEADER_KEY, X_MS_ORIGIN_HEADER_VALUE);  <= Was the bad guy