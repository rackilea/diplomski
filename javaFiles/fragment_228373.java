public class TestJerseyServer {
    public static void main(String[] args) throws Exception {
        ResourceConfig config = new ResourceConfig();
        config.packages("jetty.practice.resources");
        ServletHolder jerseyServlet 
                        = new ServletHolder(new ServletContainer(config));

        Server server = new Server(8080);
        ServletContextHandler context 
                = new ServletContextHandler(server, "/");
        context.addServlet(jerseyServlet, "/*");
        server.start();
        server.join();
    }
}