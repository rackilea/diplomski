private void startServer() throws Exception
{
    this.server = new Server(8080);
    ServletContextHandler root =
        new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);

    root.addEventListener(new GuiceConfig());
    root.addFilter(GuiceFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));
    root.addServlet(EmptyServlet.class, "/*");

    this.server.start();
}