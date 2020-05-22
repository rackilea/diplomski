// Setup SSL
    SslContextFactory sslContextFactory = new SslContextFactory();
    sslContextFactory.setKeyStorePath("/path/to/keystore");
    sslContextFactory.setKeyStorePassword("password");
    sslContextFactory.setKeyManagerPassword("password");

    // Setup HTTPS Configuration
    HttpConfiguration httpsConf = new HttpConfiguration();
    httpsConf.setSecurePort(8443);
    httpsConf.setSecureScheme("https");
    httpsConf.addCustomizer(new SecureRequestCustomizer()); // adds ssl info to request

    // Establish the ServerConnector
    ServerConnector httpsConnector = new ServerConnector(server,
            new SslConnectionFactory(sslContextFactory,"http/1.1"),
            new HttpConnectionFactory(httpsConf));
    httpsConnector.setPort(httpsPort);

    server.addConnector(httpsConnector);