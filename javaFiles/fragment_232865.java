final HttpServer server = ServerBootstrap.bootstrap()
            .setConnectionFactory(connectionFactory)
            .setListenerPort(9090)
            .setHttpProcessor(httpProcessor)
            .setSocketConfig(socketConfig)
            .setExceptionLogger(new StdErrorExceptionLogger ())
            .setHandlerMapper(handle_map)
            .create();
    server.start();