Server server = new Server();

    HttpConfiguration http_config = new HttpConfiguration();
    http_config.setSendServerVersion(true);
    http_config.setSendDateHeader(false);

    ServerConnector http = new ServerConnector(server, new HttpConnectionFactory(http_config));
    http.setPort(8080);
    http.setIdleTimeout(45000);
    server.addConnector(http);

    ServletContextHandler context = new ServletContextHandler();
    context.setContextPath("/");

    ServletHolder proxyHolder = new ServletHolder("proxy", AsyncProxyServlet.class);
    proxyHolder.setInitParameter("idleTimeout", "44000");
    context.addServlet(proxyHolder, "/proxy");

    ServletHolder defHolder = new ServletHolder("default", DefaultServlet.class);
    context.addServlet(defHolder, "/");

    HandlerList handlers = new HandlerList();
    handlers.addHandler(context);
    handlers.addHandler(new DefaultHandler());

    server.setHandler(handlers);
    server.start();
    server.join(); // wait for server thread to finish