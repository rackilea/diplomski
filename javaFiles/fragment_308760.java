/* ConnectDevice.java
 * This class is implementing runnable because i have a thread running that is checking
 * the contents of a socket. Irrelevant to events. */
public class ConnectDevice implements Runnable {

    private List _listeners = new ArrayList();
    private String data;

    /* Constructor */
    public ConnectDevice() {// does some socket stuff here, irrelevant to the events}
    public void run() {// does some socket stuff here, irrelevant to the events}

    public synchronized void addDataReceivedListener(DataReceivedListener listener) {
        _listeners.add(listener);
    }
    public synchronized void removeDataReceivedListener(DataReceivedListener listener) {
        _listeners.remove(listener);
    }
    private synchronized void fireDataReceivedEvent(String temp) {
        DataReceivedEvent dRE = new DataReceivedEvent(this, temp);
        Iterator listeners = _listeners.iterator();
        while(listeners.hasNext()) {
            ((DataReceivedListener)listeners.next()).dataReceivedReceived(dRE);
        }
    }
    public interface DataReceivedListener {
        public void dataReceivedReceived(DataReceivedEvent event);
    }
}