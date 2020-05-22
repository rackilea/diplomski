IOReactorConfig ioReactorConfig = IOReactorConfig.custom()
        .setSelectInterval(100)
        .setSoTimeout(100)
        .setConnectTimeout(100)
        .build();
CloseableHttpAsyncClient httpClient = HttpAsyncClients.custom()
        .setDefaultIOReactorConfig(ioReactorConfig)
        .build();