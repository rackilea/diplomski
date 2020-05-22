public class CounterTest {    
    public static void main(String[] args) throws InterruptedException {   
        MyCounter counter = new MyCounter();

        Thread thread1 = new Thread(new CounterIncRunnable(counter));
        thread1.setName("add thread");
        thread1.start();

        Thread thread2 = new Thread(new CounterIncRunnable(counter));
        thread2.setName("add thread2");
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter.value());
    }    
}


class CounterIncRunnable implements Runnable {
    private MyCounter counter;

    public CounterIncRunnable(MyCounter counter) {
        this.counter = counter;
    }

    public void run() {
        for ( int i=0; i<1000000; i++ ) {
            counter.increment();
        }
    }
}


class MyCounter {
    private volatile int c = 0;

    public  void increment() {
        c++;
    }

    public   void decrement() {
        c--;
    }

    public  int value() {
        return c;
    }    
}