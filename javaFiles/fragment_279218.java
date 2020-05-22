public CompletableFuture<ExecutionContext> createFuture() {
    CompletableFuture<Throwable> timeout=createTimeoutFuture(DURATION);
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
    timeout.exceptionally(t -> new DatasourceTimeoutException(t))
           .thenAcceptBoth(proc, (x, process) -> {
                if(process.isAlive()) {
                    process.destroyForcibly();
                    result.completeExceptionally(x);
                }
            });
    return result;
}