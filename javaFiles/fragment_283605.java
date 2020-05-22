public static <T> CompletableFuture<T> create(Supplier<T> s) {
    return CompletableFuture.supplyAsync(s);
}
public static <T,R> CompletableFuture<R> create(
  Function<T,R> f, CompletableFuture<T> a) {
    return CompletableFuture.supplyAsync(()->f.apply(a.join()));
}
public static <T,U,R> CompletableFuture<R> create(
  BiFunction<T,U,R> f, CompletableFuture<T> a, CompletableFuture<U> b) {
    return CompletableFuture.supplyAsync(()->f.apply(a.join(),b.join()));
}