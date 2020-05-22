public class RefreshRequest<K> {
    public final K key;
    public RefreshRequest(K key) { this.key = key; }
}

public final BlockingQueue<RefreshRequest<?>> requestQueue = new ArrayBlockingQueue<>(200);
public final int concurrency = 4;
public final ExecutorService executor = Executors.newFixedThreadPool(4);

for(int i = 0; i < concurrency; i++) {
    executor.execute(new Runnable() {
        public void run() {
            try {
                while(true) {
                    RefreshRequest<?> request = requestQueue.take();
                    // refresh key
                }
            } catch(InterruptedException e) {
                return; // maybe log the exception as well
            }
        }
    };
}