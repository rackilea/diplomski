public class YourClass {
    private Lock outboxLock = new ReentrantLock();
    public void processOutbox() {
        outboxLock.lock()
        try {
            // do stuff
        } finally {
            outboxLock.unlock()
        }
    }
}