public void test() {
    int numberOfThreads = 5;
    ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
    for(int i=0; i<numberOfThreads; i++){
        executorService.submit(createRunnable());
    }
}

private Runnable createRunnable() {
    return new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Start" + "  " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("End!" + "  " + Thread.currentThread().getName());
            }
        }
    };
}