/**
 * A Lambda handler to see where this runs and when instances are reused.
 */
public class LambdaStatus {

    private String hostname;
    private AtomicLong counter;

    public LambdaStatus() throws UnknownHostException {
        this.counter = new AtomicLong(0L);
        this.hostname = InetAddress.getLocalHost().getCanonicalHostName();
    }

    public void handle(Context context) {
        counter.getAndIncrement();
        context.getLogger().log("hostname=" + hostname + ",counter=" + counter.get());
    }
}