Thread t1 = new Thread(new Runnable() {

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
    }
});
Thread t2 = new Thread(new Runnable() {

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
});
t1.start();   // this will be RUNNABLE
t2.start();   // this will be TIMED_WAITING
System.out.println(Thread.currentThread().getThreadGroup().activeCount());