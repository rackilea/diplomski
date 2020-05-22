public class Example {

    public static void main(String[] args) {

        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(GreetingsResource.class);

        HttpHandler handler = RuntimeDelegate.getInstance()
                .createEndpoint(resourceConfig, HttpHandler.class);

        HttpServer server = HttpServer.createSimpleServer(null, 8080);
        server.getServerConfiguration().addHttpHandler(handler);

        try {
            server.start();
            System.out.println("Press any key to stop the server...");
            System.in.read();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Path("/greetings")
    public static class GreetingsResource {

        @GET
        @Produces(MediaType.TEXT_PLAIN)
        public String getGreeting(){
            return "Hello from the other side.";
        }
    }
}