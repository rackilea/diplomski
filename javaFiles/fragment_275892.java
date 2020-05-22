// Create an executor that can run up to 10 jobs in parallel.
ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 5, TimeUnit.Seconds, new LinkedBlockingQueue());
while(it.hasNext()) {
    // NB: Final is needed so that this can be accessed within the anonymous inner class
    final MyObject obj = (MyObject)it.next();
    // Queue up the doSomething to be run by one of the 10 threads
    executor.execute(new Runnable() {
        public void run() {
            doSomething(obj);
        }
    }
}