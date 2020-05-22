// We don't use return values for anything here, so
// we just use Object.
public class YourTask extends Callable<Object> {
    private DatagramPacket received;

    public YourTask(DatagramPacket received) {
        this.received = received;
    }

    public Object call() {
        // do your processing here
        System.out.println("RECEIVED from " +
            received.getAddress() +
            ": " + new String(received.getData(),
                              0, received.getLength()));
        return null;
    }
}