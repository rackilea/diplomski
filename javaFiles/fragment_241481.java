Server server = new Server();

    server.setStopAtShutdown(true);
    ServerConnector connector = new ServerConnector(server);
    //allow connection from all internal ip's
    connector.setPort(8000);
    server.addConnector(connector);

    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    context.setResourceBase(resourceBase);

    ContextHandlerCollection contexts=new ContextHandlerCollection();
    contexts.setHandlers(new Handler[]{context});

    server.setHandler(contexts);

    context.addServlet(DefaultServlet.class, "/");

    server.start();
    LOG.info("WebServer started.");