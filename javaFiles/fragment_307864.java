private static String API_PACKAGE = "package where TestRESTService class";

public static final URI BASE_URI = UriBuilder
        .fromUri("http://localhost/")
        .port(8000)
        .build();

private static HttpServer initServer() throws IOException {
    System.out.println("Starting grizzly... " + BASE_URI);

    HttpServer httpServer = GrizzlyServerFactory.createHttpServer(BASE_URI, new HttpHandler() {
        @Override
        public void service(Request rqst, Response rspns) throws Exception {
            rspns.sendError(404);
        }
    });

    // Initialize and register Jersey Servlet
    WebappContext context = new WebappContext("GrizzlyContext", "/");
    ServletRegistration registration = context.addServlet(
            ServletContainer.class.getName(), ServletContainer.class);
    registration.setInitParameter(ServletContainer.RESOURCE_CONFIG_CLASS,
            PackagesResourceConfig.class.getName());
    registration.setInitParameter(PackagesResourceConfig.PROPERTY_PACKAGES, API_PACKAGE);
    registration.addMapping("/*");
    context.deploy(httpServer);

    return httpServer;
}