public class CachedFunction<T, R> implements Function<T, R> {
    private final Function<T, R> function;
    private final Map<T, R> cache = new ConcurrentHashMap<>();

    public CachedFunction(Function<T, R> function) {
        this.function = function;
    }

    @Override
    public R apply(T t) {
        return cache.computeIfAbsent(t, t2 -> function.apply(t2));
    }
}