private static HttpServer create(URI u, Servlet servlet) throws IOException {

    String path = u.getPath();
    path = String.format("/%s", UriComponent.decodePath(u.getPath(), true)
                 .get(1).toString());

    WebappContext context = new WebappContext("GrizzlyContext", path);
    context.addListener(MyListener.class);
    ServletRegistration registration;
    registration = context.addServlet(servlet.getClass().getName(), servlet);
    registration.addMapping("/*");

    HttpServer server = GrizzlyHttpServerFactory.createHttpServer(u);
    context.deploy(server);
    return server;
}