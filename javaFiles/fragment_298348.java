class ThreadTestX implements Runnable {

    static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
    static AtomicInteger value_to_be_incremented_stored = new AtomicInteger(0); // variable whose value to be updated
    static AtomicInteger i = new AtomicInteger(0);  // this runs the loop
    static final Object lock = new Object();

    @Override
    public void run() {

        for ( ; i.incrementAndGet() <= 100000;  ) {
            /*
                This loop should run 100000 times and when loop terminates according to me value of variable 
                "value_to_be_incremented_stored" should be 100000 as its value is incremented 
                100000 times the loop also runs 100000 times. 
            */
            synchronized( lock ) {
                value_to_be_incremented_stored.incrementAndGet();
    //            System.out.println("Thread > " + Thread.currentThread() + 
    //                 "  " + value_to_be_incremented_stored.get());
                map.put("TC", value_to_be_incremented_stored.intValue());
            }
        }

        System.out.println("Output by Thread  " + Thread.currentThread() 
                + "     " + map.toString());
    }

    public static void main(String[] args) {

        ThreadTestX t1 = new ThreadTestX();
        Thread thread1 = new Thread(t1);
        thread1.setName("Thread 1");

        Thread thread2 = new Thread(t1);
        thread2.setName("Thread 2");

        Thread thread3 = new Thread(t1);
        thread3.setName("Thread 3");

        Thread thread4 = new Thread(t1);
        thread4.setName("Thread 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}