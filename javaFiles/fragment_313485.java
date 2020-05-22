public class App
{
    public static void main(String[] args) {

        URI baseUri = UriBuilder.fromUri("http://127.0.0.1/").port(8050).build();
        ResourceConfig config = new ResourceConfig(RestController.class);
        Server server = JettyHttpContainerFactory.createServer(baseUri, config);

    }
}