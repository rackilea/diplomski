final HttpClientOptions options = new HttpClientOptions();
    options.setTrustAll(true);
    final String proxyUrl = "yourProxyUrl.net";
    options.setSsl(true);
    int port = 443;
    final ProxyOptions proxyOptions = new ProxyOptions().setHost(proxyUrl).setPort(port);
    options.setProxyOptions(proxyOptions);
    options.setDefaultPort(port);
    HttpClient httpClient= vertx.createHttpClient(options);

    httpClient.requestAbs(apiMethod.getHttpMethod(), uri, resultHandler -> {
        resultHandler.statusCode();
        if (resultHandler.statusCode() == 200) {
            environment.setStatus(ApiStatus.OK);
            apiMethod.setStatus(ApiStatus.OK);
        } else {
            environment.setStatus(ApiStatus.ERROR);
            apiMethod.setStatus(ApiStatus.ERROR);
        }
        resultHandler.bodyHandler(buffer -> {
            logger.debug("Output from Server .... \n");
            buffer.toString();
        });
    }).exceptionHandler(handlerExc -> {
        logger.error(" handle exception:" + handlerExc.getMessage(), handlerExc.getCause());
        apiMethod.setStatus(ApiStatus.ERROR);
        environment.setStatus(ApiStatus.ERROR);
        apiMethod.setCallingResult(handlerExc.getMessage());

    }).putHeader("content-type", "application/json").end();