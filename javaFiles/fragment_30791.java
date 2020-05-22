public static void main(String[] args) throws Exception {
    Server server = new Server(9001);
    Context context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.addServlet(new ServletHolder(new ServletContainer(new ResourceConfig(YourRestService.class)));
    server.start();
}