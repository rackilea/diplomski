import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class ProducerConsumer {
    //Queue Creation
    private final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
    private final Random theRandom = new Random();
    //Semaphore Creation
    static Semaphore semProd = new Semaphore(1);
    static Semaphore semCon = new Semaphore(0);

    public volatile boolean done_processing = false;
    public volatile boolean done_consuming = false;

    public int num_items = 0;
    private int size_buffer = 0;

    public volatile int num_produced = 0;
    public volatile int num_consumed = 0;

    public ProducerConsumer(int size_buffer, int num_items) {
        this.size_buffer = size_buffer;
        this.num_items = num_items;
    }

    public void put() throws InterruptedException {
        if (semProd.tryAcquire(100, TimeUnit.MILLISECONDS)) {
            try {
                if (num_produced >= num_items) {
                    done_processing = true;
                    return;
                }
                if (queue.size() == size_buffer) {
                    return;
                }
                int number = theRandom.nextInt();
                boolean isAdded = queue.add(number);
                num_produced++;
            } finally {
                semCon.release();
            }
        }
    }

    public void get() throws InterruptedException {
        if (semCon.tryAcquire(100, TimeUnit.MILLISECONDS)) {
            try {
                if (num_consumed >= num_items) {
                    done_consuming = true;
                    return;
                }
                if (queue.isEmpty()) {
                    return;
                }
                Integer value = queue.take();
                num_consumed++;
            } finally {
                semProd.release();
            }
        }
    }
}