/**
 * Returns a new CompletableFuture that is already completed
 * exceptionally with the given exception.
 *
 * @param ex the exception
 * @param <U> the type of the value
 * @return the exceptionally completed CompletableFuture
 * @since 9
 */
public static <U> CompletableFuture<U> failedFuture(Throwable ex) {
    if (ex == null) throw new NullPointerException();
    return new CompletableFuture<U>(new AltResult(ex));
}