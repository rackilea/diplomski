import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class Sequence extends Thread{

    private final AtomicInteger integer;
    private AtomicBoolean flag;

    public Sequence(AtomicInteger integer, AtomicBoolean flag) {
        this.integer=integer;
        this.flag=flag;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (integer) {
                while (flag.get()) {
                    flag.set(false);
                    try {
                        System.out.println(Thread.currentThread().getName()+" waiting");
                        integer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+" "+integer.incrementAndGet());
                flag.set(true);
                System.out.println(Thread.currentThread().getName()+" notifying");
                integer.notify();
            }
        }
    }
}