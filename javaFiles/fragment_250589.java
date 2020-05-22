public class RunAfterNThreads {

public static void main(String[] args) throws ExecutionException, InterruptedException {
    CompletableFuture.supplyAsync(RunAfterNThreads::runFirstBatchOfThreads)
            .thenAcceptAsync((t) -> runSecondBatchOfThreads(null)).get();
}

private static Object runSecondBatchOfThreads(Object something) {
    return something;
}

private static <U> U runFirstBatchOfThreads() {
    return null;
}