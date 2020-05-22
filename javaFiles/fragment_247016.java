@Command(name = "http-server", description = "Starts HTTP server")
public class HttpApp implements Runnable {
    @Override
    public void run() {
        Micronaut.run(HttpApp.class);
    }
}