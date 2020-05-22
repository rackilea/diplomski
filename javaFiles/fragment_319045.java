private static void reactorProcess()
{
    ExecutorService executor = Executors.newFixedThreadPool(1024);

    Flux.range(1, 1024)
        .flatMap(a -> Mono.fromRunnable(() -> simulateHttpCall())
                          .subscribeOn(Schedulers.fromExecutor(executor)))
        .blockLast();

    executor.shutdown();
}

private static void simulateHttpCall()
{
    try
    {
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + ": " + ZonedDateTime.now());
    } catch (InterruptedException e)
    {
        e.printStackTrace();
    }
}