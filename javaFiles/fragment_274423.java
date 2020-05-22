public class Foo implements Runnable {
    private volatile int itemsProcessed;

    public int getItemsProcessed() { return itemsProcessed; }

    @Override
    public void run() {
        while (true) { //this is just an example so we don't care about stopping
            processItem(); //process a single item
            itemsProcessed++;
        }
    }
}