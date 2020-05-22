public void execute() throws Exception {
    ExecutorService executorService = Executors.newFixedThreadPool(2);

    Future<Integer> future1 = executorService.submit(this::countA);
    Future<Integer> future2 = executorService.submit(this::countB);

    // wait until result will be ready
    Integer result1 = future1.get();

    // wait only certain timeout otherwise throw an exception
    Integer result2 = future2.get(1, TimeUnit.SECONDS);

    System.out.println("result1 = " + result1);
    System.out.println("result2 = " + result2);

    executorService.shutdown();
}