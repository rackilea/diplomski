WampClient client;
    try {
        WampClientBuilder builder = new WampClientBuilder();
        IWampConnectorProvider connectorProvider = new NettyWampClientConnectorProvider();
        builder.withConnectorProvider(connectorProvider)
                .withUri("wss://api.poloniex.com")
                .withRealm("realm1")
                .withInfiniteReconnects()
                .withReconnectInterval(5, TimeUnit.SECONDS);
        client = builder.build();

    } catch (Exception e) {
        return;
    }