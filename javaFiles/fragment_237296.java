public class MyThread1 extends Thread {

public MyThread1(Runnable task) {
    super(task);
    setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("thread throws an uncaught exception at thread id: " + t.getId());
        }
    });
}