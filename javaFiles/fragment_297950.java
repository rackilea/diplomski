public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Job
        IJob mockJob = new MockJob();

        // Async task
        FutureTask<IResult> asyncTask = new FutureTask<>(mockJob::execute);
        Thread mockJobThread = new Thread(asyncTask);

        // Show result
        Thread showResultThread = new Thread(() -> {
            try {
                IResult result = asyncTask.get();
                MockResult mockResult = (MockResult) result;
                Thread thread = Thread.currentThread();
                System.out.println(String.format("%s: isCancelled = %s, result = %d",
                        thread.getName(),
                        mockResult.isCancelled(),
                        mockResult.getResult()
                ));
            } catch (InterruptedException | ExecutionException ex) {
                // NO-OP
            }
        });

        // Check status
        Thread monitorThread = new Thread(() -> {
            try {
                while (!asyncTask.isDone()) {
                    Thread thread = Thread.currentThread();
                    System.out.println(String.format("%s: asyncTask.isDone = %s",
                            thread.getName(),
                            asyncTask.isDone()
                    ));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                // NO-OP
            }
            Thread thread = Thread.currentThread();
            System.out.println(String.format("%s: asyncTask.isDone = %s",
                    thread.getName(),
                    asyncTask.isDone()
            ));
        });

        // Async cancel
        Thread cancelThread = new Thread(() -> {
            try {
                // Play with this Thread.sleep, set to 15000
                Thread.sleep(5000);
                if (!asyncTask.isDone()) {
                    Thread thread = Thread.currentThread();
                    System.out.println(String.format("%s: job.cancel()",
                            thread.getName()
                    ));
                    mockJob.cancel();
                }
            } catch (InterruptedException ex) {
                // NO-OP
            }
        });

        monitorThread.start();
        showResultThread.start();
        cancelThread.setDaemon(true);
        cancelThread.start();
        mockJobThread.start();
    }
}