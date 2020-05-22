static Thread t1, t2, t3;

static void someFunction() {
    t1 = new MyThread(5000, "Thread 1");
    t2 = new MyThread(7000, "Thread 2");
    t3 = new MyThread(8000, "Thread 3");
    // now start them all
    t1.start();
    t2.start();
    t3.start();
}