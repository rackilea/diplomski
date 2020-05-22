AtomicInteger count = new AtomicInteger(0);

@Test
public void executeParallel() {
    List<Object> result = new SimpleReact(Executors.newFixedThreadPool(1))
            .of(getSupplier())
            .withRetrier(new AsyncRetryExecutor(Executors.newScheduledThreadPool(1))
            .retry(Supplier::get)
            .block()
            .collect(Collectors.toList());
    System.out.println(result);
}

private Supplier<String> getSupplier() {
    return () -> {
        System.out.println("Attempt " + count.incrementAndGet());
        if(count.get()<4)
            throw ExceptionSoftener.throwSoftenedException(new TimeoutException());
        return "success";
    };
}