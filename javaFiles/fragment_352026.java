final ExecutorService executorService = Executors.newFixedThreadPool(10);

CompletableFuture.supplyAsync(() -> {
    try {
        return hystrixCommand.queue();
    } catch (Exception e) {
        return false;
    }
}, executorService);