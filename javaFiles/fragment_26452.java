public static HttpServer startServer() {
    final ResourceConfig rc = new ResourceConfig().packages("dk.kb.dpa.verapdf");
    HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    httpServer.getHttpHandler().setAllowEncodedSlash(true);
    return httpServer;
}