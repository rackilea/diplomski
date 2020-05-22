private static final ScheduledExecutorService scheduler =
        Executors.newScheduledThreadPool(
                1,
                new ThreadFactoryBuilder()
                        .setDaemon(true)
                        .setNameFormat("failAfter-%d")
                        .build());

public static void main(String[] args) throws InterruptedException, ExecutionException {
    System.out.println("start");
    final CompletableFuture<Object> oneSecondTimeout = failAfter(Duration.ofSeconds(1))
            .exceptionally(xxx -> "timeout exception");
    List<Object> collect = Stream.of("1", "2", "3", "4", "5", "6", "7")
            .map(x -> CompletableFuture.anyOf(createTaskSupplier(x)
                    , oneSecondTimeout))
            .collect(Collectors.toList())
            .stream()
            .map(CompletableFuture::join)
            .collect(Collectors.toList());
    System.out.println("stop out!");
    System.out.println(collect);
}

public static CompletableFuture<String> createTaskSupplier(String x) {
    return CompletableFuture.supplyAsync(getStringSupplier(x))
            .exceptionally(xx -> "PROCESSING ERROR : " + xx.getMessage());
}


public static Supplier<String> getStringSupplier(String text) {
    return () -> {

        System.out.println("start " + text);
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (text.equals("1")) {
            throw new RuntimeException("LOGIC ERROR");
        }
        try {
            if (text.equals("7"))
                TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("stop " + text);
        return "result " + text;
    };
}

public static <T> CompletableFuture<T> failAfter(Duration duration) {
    final CompletableFuture<T> promise = new CompletableFuture<>();
    scheduler.schedule(() -> {
        final TimeoutException ex = new TimeoutException("Timeout after " + duration);
        return promise.completeExceptionally(ex);
    }, duration.toMillis(), MILLISECONDS);
    return promise;
}