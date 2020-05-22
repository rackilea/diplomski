public class YourClass {
    private Lock outboxLock = new ReentrantLock();
    public void processOutbox() {
        if( outboxLock.tryLock() ) {  
            try {
                // do stuff
            } finally {
                outboxLock.unlock()
            }
        }
    }
}