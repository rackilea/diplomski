import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class ComparableRunnable implements Runnable {

    public int index;

    ComparableRunnable(int index) {
        this.index = index;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "-index : " + index);
        try {
            // sleep current thread, so the other thread can print
            // this is not mandatory, without this, the result might not follow strict natural order
            // for example, thread1 print 1, 
            // thread2 take 2 but did not print it immediatly, 
            // thread1 print 3, 
            // thread2 print 2
            // the result will be 1, 3, 2,
            Thread.sleep(10);
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        int corePoolSize = 2; // fixed thread number
        long ignore = 0L;

        // comparator
        Comparator<Runnable> comparator = new Comparator<Runnable>() {
            @Override
            public int compare(Runnable o1, Runnable o2) {
                int index1 = ((ComparableRunnable)o1).index;
                int index2 = ((ComparableRunnable)o2).index;
                // you should implement this method based on your own order
                return Integer.compare(index1, index2);
            }
        };

        // use the comparator create a priority queue
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>(10, comparator);

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(corePoolSize, corePoolSize, ignore, TimeUnit.SECONDS, queue);

        // Warm the thread pool up
        // this is not mandatory, without this, it will print 1000, 999, 1, 2, ...., 998
        // because the first two Runnbale will be executed once they are submitted
        for (int i = 0; i < corePoolSize; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            });
        }

        // submit in 1000, 999, ..., 1 order
        // print in 1, 2, 3, ..., 1000 order
        for (int i = 1000; i > 0; i--) {
            executor.execute(new ComparableRunnable(i));
        }
    }
}