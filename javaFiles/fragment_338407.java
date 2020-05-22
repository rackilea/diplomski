protected static HttpServer startServer() throws IOException {
    System.out.println("Starting grizzly...");
    final ResourceConfig rc = new PackagesResourceConfig("amplify.api.resources");
    rc.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
    return GrizzlyServerFactory.createHttpServer(BASE_URI, rc);
}