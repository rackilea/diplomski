public class QueueExecutor implements CallbackInterface<String> {

    public static final int NO_THREADS = 26;

    private Object syncObject = new Object();
    private AtomicInteger count;
    Queue<String> queue = new LinkedList<String>();

    public void execute() {
        count = new AtomicInteger(NO_THREADS);
        ExecutorService executor = Executors.newFixedThreadPool(NO_THREADS/2);
        for(int i=0;i<NO_THREADS;i++)
            executor.execute(new ExecutorTask<String>("" + (char) ('A'+i), queue, this));

        Iterator<String> iter = new QueueIterator<String>(queue, count);
        int count = 0;
        while (iter.hasNext()) {

            System.out.println(iter.next());
            count++;
        }

        System.out.println("Handled " + count + " items");
    }

    public void callback(String result) {
        System.out.println(result);
        count.decrementAndGet();
        synchronized (syncObject) {
            syncObject.notify();
        }
    }

    public class QueueIterator<T> implements Iterator<T> {
        private Queue<T> queue;
        private AtomicInteger count;

        public QueueIterator(Queue<T> queue, AtomicInteger count) {
            this.queue = queue;
            this.count = count;
        }

        public boolean hasNext() {          
            while(true) {                   
                synchronized (syncObject) {
                    if(queue.size() > 0)
                        return true;

                    if(count.get() == 0)
                        return false;

                    try {
                        syncObject.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public T next() {

            synchronized (syncObject) {
                if(hasNext())
                    return queue.remove();
                else
                    return null;
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    class ExecutorTask<T> implements Runnable {
        private String name;
        private Queue<T> queue;
        private CallbackInterface<T> callback;

        public ExecutorTask(String name, Queue<T> queue,
                CallbackInterface<T> callback) {
            this.name = name;
            this.queue = queue;
            this.callback = callback;
        }

        @SuppressWarnings("unchecked")
        public void run() {
            try {
                Thread.sleep(1000);
                                    Random randomX = new Random();
                for (int i = 0; i < 5; i++) {
                    synchronized (syncObject) {
                        Thread.sleep(randomX.nextInt(10)+1);

                        queue.add((T) (name + ":" + ":" + i));
                        syncObject.notify();
                    }
                }

                callback.callback((T) (name + ": Done"));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public interface CallbackInterface<T> {
    void callback(T result);
}