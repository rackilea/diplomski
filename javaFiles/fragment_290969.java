// Setup Threadpool for multiple server connections
    QueuedThreadPool threadPool = new QueuedThreadPool();
    threadPool.setMaxThreads(500);

    //ThreadPool Server
    Server server = new Server(threadPool);
    int port = 9889;
    int portSecure = 9888;

    // Configure jetty.home 
    String home = ".";

    // HTTP Configuration
    HttpConfiguration http_config = new HttpConfiguration();
    http_config.setSecureScheme("https");
    http_config.setSecurePort(portSecure);

    // Configure Connector for http
    ServerConnector http = new ServerConnector(server,
            new HttpConnectionFactory(http_config));
    http.setPort(port);
    http.setIdleTimeout(30000);

    // HTTPS Configuration
    HttpConfiguration https_config = new HttpConfiguration(http_config);
    https_config.addCustomizer(new SecureRequestCustomizer());

    SslContextFactory sslContextFactory = new SslContextFactory();
    sslContextFactory.setKeyStorePath(home + "/keystore.jks");
    sslContextFactory.setKeyStorePassword("XXXXXXXXXX");
    sslContextFactory.setKeyManagerPassword("XXXXXXXXXXX");

    ServerConnector sslConnector = new ServerConnector(server,
            new SslConnectionFactory(sslContextFactory, "http/1.1"),
            new HttpConnectionFactory(https_config));
    sslConnector.setPort(portSecure);

    server.setConnectors(new Connector[] { http, sslConnector });