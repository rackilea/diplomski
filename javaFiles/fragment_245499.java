Server server = new Server(80);
server.setStopAtShutdown(true);

ServletContextHandler context = new ServletContextHandler();
context.addServlet(Erreur500Servlet.class, "/generate-error-500");
context.addServlet(AresServlet.class, "/ares/*");
context.addFilter(RequestLoggingFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));

server.setHandler(context);
server.start();
server.join();