ExecutorService executor = Executors.newCachedThreadPool();
for (int i = 1; i <= 5; i++) {  
    int final taskNo = i;
    executor.submit(new Runnable() {
        public void run() {
           // perform 'mycalculate' for task 'taskNo'
        }
    });
}