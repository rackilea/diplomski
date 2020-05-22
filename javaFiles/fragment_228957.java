/**
 * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
 * @return Grizzly HTTP server.
 */
public static HttpServer startServer() {
    // create a resource config that scans for JAX-RS resources and providers
    // in $package package
    final ResourceConfig rc = new ResourceConfig().packages("$package");

    // create and start a new instance of grizzly http server
    // exposing the Jersey application at BASE_URI
    return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
}