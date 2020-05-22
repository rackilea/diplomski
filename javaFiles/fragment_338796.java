Server server = new Server(8080);
ServletContextHandler contextHandler = new ServletContextHandler(
            ServletContextHandler.SESSIONS);
contextHandler.addEventListener(new SomeListener());
contextHandler.addFilter(SomeFilter.class, "/*", EnumSet.of(
            DispatcherType.REQUEST, DispatcherType.FORWARD,
            DispatcherType.INCLUDE, DispatcherType.ERROR));
contextHandler.addServlet(new ServletHolder(DefaultServlet.class), "/");
contextHandler.addServlet(new ServletHolder(new ServletContainer(
            new SomeJerseyApplication())), "/basepath/*");
server.setHandler(contextHandler);

server.start();
server.join();