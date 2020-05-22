public class MyApp extends ResourceConfig {

    public MyApp(String directory) {
        register(MyResource.class);

        Map<String, Object> properties = new HashMap<>();
        properties.put("directory", directory);
        setProperties(properties);
    }

    public void startHttpServer(int port) { ... }

    public static void main(String[] args)  {
        final MyApp app = new MyApp(args[1]);
        int port = Integer.parseInt(args[0]);
        app.startHttpServer(port);
    }
}