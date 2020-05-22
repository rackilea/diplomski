final List<CompletableFuture<List<Test>>> completableFutures = resolvers.stream()
    .map(resolver -> supplyAsync(() -> task.doWork()))
    .collect(toList());

CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture<?>[0]))
    .thenAccept(justVoid -> {
        // here, all jobs have been completed
        final List<Test> tests = completableFutures.stream()
            .flatMap(completableFuture -> completableFuture.join().stream())
            .collect(toList());
        // process the result here
    });