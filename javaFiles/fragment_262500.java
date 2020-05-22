// Task that will only sleep for 1 sec and print a message on interrupted
FutureTask<Void> myRunnable = new FutureTask<>(
    new Callable<Void>() {
        @Override
        public Void call() throws Exception {
            try {
                System.out.println("Sleep");
                Thread.sleep(1_000L);
            } catch (InterruptedException e) {
                System.out.println("Interrupted !!!");
                throw e;
            }
            return null;
        }
    }
);
new Thread(myRunnable, "myRunnableThread").start();

// Wait long enough to make sure that myRunnableThread is sleeping 
Thread.sleep(500L);
// Cancel the task and interrupt myRunnableThread
myRunnable.cancel(true);