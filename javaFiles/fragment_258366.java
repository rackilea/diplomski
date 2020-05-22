public class GateLock {
    private boolean isOpen;
    public GateLock() {
        isOpen = false;
    }

    public synchronized void open(){
        isOpen = true;
        notifyAll();
    }

    public synchronized void close(){
        isOpen = false;
    }

    public synchronized void enter(){
        while(!isOpen) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
    }
}