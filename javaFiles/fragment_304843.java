@Test
public void parallelTestWillFail() throws InterruptedException, ExecutionException {
    ExecutorService executor = Executors.newFixedThreadPool(10);
    Runnable testcaseNotOk = () -> fail("This failure IS raised.");
    List<Future<?>> futures = IntStream.range(0, 20)
                                .mapToObj(i -> executor.submit(testcaseNotOk))
                                .collect(Collectors.toList());
    executor.shutdown();
    for(Future<?> f : futures){
        f.get();
    }
}