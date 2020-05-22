public class Producer implements Runnable {
    private final BlockingQueue sharedQueue;

    public Producer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void pushItem(int item) throws InterruptedException {
        System.out.println("Produced: " + item);
        sharedQueue.put(item);
    }

    @Override
    public void run() {
        //I don't want to write in the queue the counter values. I want to put my own values, when I receive them from outside **
        for(int i=0; i<10; i++){
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
                //Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}