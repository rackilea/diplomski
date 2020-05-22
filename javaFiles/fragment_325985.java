public class ExampleServer {

    public static void main(String[] args) {

            URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
            ResourceConfig config = new ResourceConfig(TestResource.class);
            Server server = JettyHttpContainerFactory.createServer(baseUri, config);
       }
}