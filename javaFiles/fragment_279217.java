public CompletableFuture<ExecutionContext> createFuture() {
    CompletableFuture<Process> proc=CompletableFuture.supplyAsync(
        () -> {
            try {
                return new ProcessBuilder(COMMAND).redirectErrorStream(true).start();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }, SCHEDULER);
    CompletableFuture<ExecutionContext> result
        =proc.thenApplyAsync(process -> PARSER.parse(process.getInputStream()), SCHEDULER);
    proc.thenAcceptAsync(process -> {
        if(!process.waitFor(DURATION, TimeUnit.WHATEVER_DURATION_REFERS_TO)) {
            process.destroyForcibly();
            result.completeExceptionally(
                new DatasourceTimeoutException(new TimeoutException()));
        }
    });
    return result;
}