import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Start: " + Thread.currentThread().getName());
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread one = new Thread(myRunnable);
        Thread two = new Thread(myRunnable);
        one.start();
        two.start();

        List<Thread> threads = getThreadsFor(myRunnable);
        for (Thread thread : threads)
            System.out.println("Found: " + thread.getName());
    }

    private static List<Thread> getThreadsFor(Runnable myRunnable) throws Exception {
        Method getThreads = Thread.class.getDeclaredMethod("getThreads");
        Field target = Thread.class.getDeclaredField("target");
        target.setAccessible(true);
        getThreads.setAccessible(true);
        Thread[] threads = (Thread[]) getThreads.invoke(null);
        List<Thread> result = new ArrayList<Thread>();
        for (Thread thread : threads) {
            Object runnable = target.get(thread);
            if (runnable == myRunnable)
                result.add(thread);
        }
        return result;
    }
}