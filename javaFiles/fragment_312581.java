protected Void doInBackground() {
    final int TASK_COUNT = 10;
    getPropertyChangeSupport().addPropertyChangeListener(this);
    CountDownLatch latch = new CountDownLatch( TASK_COUNT ); // java.util.concurrent
    Collection<Thread> threads = new HashSet<Thread>();
    for (int i = 0; i < TASK_COUNT; i++) {
        MyTask task = new MyTask( ..., latch, this.getPropertyChangeSupport() ) );
        threads.add( new Thread( task ) );
    }
    for (Thread thread: threads) {
        thread.start();
    }
    latch.await();
    return null;
}