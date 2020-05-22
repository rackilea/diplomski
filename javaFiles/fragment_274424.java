public class Foo implements Runnable {
    private volatile boolean stopped = false;

    public void stopProcessing() {
        stopped = true;
    }

    public int getItemsProcessed() { return itemsProcessed; }

    @Override
    public void run() {
        while (!stopped) { 
            processItem(); //process a single item
        }
    }
}