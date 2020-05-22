ConnectionConfig connectionConfig = ConnectionConfig.custom()
        .setCharset(Consts.ISO_8859_1)
        .build();
CloseableHttpClient client = HttpClients.custom()
        .setDefaultConnectionConfig(connectionConfig)
        .build();