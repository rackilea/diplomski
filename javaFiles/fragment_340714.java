public class ThingRunnable implements Runnable {
    private SomeListenerType listener;
    // assign listener somewhere

    public void run() {
        try {
            while(iHaveMorePackets()) { 
                doStuffWithPacket();
            }
        } catch(Exception e) {
            listener.notifyThatDarnedExceptionHappened(...);
        }
    }
 }