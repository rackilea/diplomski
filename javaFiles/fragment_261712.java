public class ClientService {

    private static final ScheduledExecutorService EXECUTOR = Executors.newScheduledThreadPool(1);

    private static final long INITIAL_DELAY = 10_000;
    private static final long UPDATE_RATE = 10_000;

    public static void main(String[] args) {
        // Fire first (full?) update trigger here
        fireInitialMigration();
        // For subsequent (incremental?) updates, schedule an HTTP POST to occur at a fixed rate:
        EXECUTOR.scheduleAtFixedRate(() -> fireSubsequentUpdate(), INITIAL_DELAY, UPDATE_RATE, TimeUnit.MILLISECONDS);
        // Keep main thread alive
        while (true);
    }

    private static void fireInitialMigration() {
        Client client = ClientBuilder.newClient();
        Response res = client.target("http://localhost/your/path/here").request("application/json").post(/* ... Entity that goes in the message body ... */);
    }

    private static void fireSubsequentUpdate() {
        // Similar to initialMigration(), but change Entity/set of HTTP POSTs according to your needs.
    }
}