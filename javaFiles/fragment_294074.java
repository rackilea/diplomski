BlockingQueue<Runnable> blockingQueue   blockingQueue = new ArrayBlockingQueue<WorkSheet_1>(48);
    ThreadPoolExecutor testExecutor = new ThreadPoolExecutor(6, 16, 1,
            TimeUnit.SECONDS, blockingQueue, new CustomThreadFactory());

    CompletionService<String> completionService = new ExecutorCompletionService<String>(
            testExecutor);

    for (int i = 0; i < test.length; i++) {
        completionService.submit(new WorkSheet_1(i));
    }

    for (int i = 0; i < test.length; i++) {
        try {
            String result = completionService.take().get();
            System.out.println("Output Returned is : " + result);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Compute the result
    }