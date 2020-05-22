public interface Retryable<T, R> extends Function<T, R>{
    void retrying(Exception e);
    void skipping(Exception e);
    int trials();
    @Override default R apply(T t) {
        try { return action(t); }
        catch(Exception e) {
            for(int trial = 1; trial < trials(); trial++) {
                retrying(e);
                try { return action(t); } catch (Exception next) { e=next; }
            }
            skipping(e);
            return null;
        }
    }

    R action(T input) throws Exception;

    public static Retryable<Void, Void> of(Consumer<Exception> retrying,
            Consumer<Exception> skipping, int trials, CheckedRunnable runnable) {
        return of(retrying, skipping, trials, x -> { runnable.tryRun(); return null; });
    }

    @FunctionalInterface interface CheckedRunnable extends Runnable {
        void tryRun() throws Exception;
        @Override default void run() {
            try { tryRun(); } catch (Exception e) { throw new RuntimeException(e); }
        }
    }

    public static <T> Retryable<T, Void> of(Consumer<Exception> retrying,
            Consumer<Exception> skipping, int trials, CheckedConsumer<T> consumer) {
        return of(retrying, skipping, trials,
                  value -> { consumer.tryAccept(value); return null; });
    }

    @FunctionalInterface interface CheckedConsumer<T> extends Consumer<T> {
        void tryAccept(T t) throws Exception;
        @Override default void accept(T t) {
            try { tryAccept(t); } catch (Exception e) { throw new RuntimeException(e); }
        }
    }

    public static <T> Retryable<Void, T> of(Consumer<Exception> retrying,
            Consumer<Exception> skipping, int trials, CheckedSupplier<T> supplier) {
        return of(retrying, skipping, trials, voidArg -> { return supplier.tryGet(); });
    }

    @FunctionalInterface interface CheckedSupplier<T> extends Supplier<T> {
        T tryGet() throws Exception;
        @Override default T get() {
            try { return tryGet(); }
            catch (Exception e) { throw new RuntimeException(e); }
        }
    }

    public static <T, R> Retryable<T, R> of(Consumer<Exception> retrying,
            Consumer<Exception> skipping, int trials, CheckedFunction<T, R> function) {
        return new Retryable<T, R>() {
            @Override public void retrying(Exception e) { retrying.accept(e); }
            @Override public void skipping(Exception e) { skipping.accept(e); }
            @Override public int trials() { return trials; }
            @Override public R action(T t) throws Exception {
                return function.tryApply(t);
            }
        };
    }

    @FunctionalInterface interface CheckedFunction<T, R> extends Function<T, R> {
        R tryApply(T t) throws Exception;
        @Override default R apply(T t) {
            try { return tryApply(t); }
            catch (Exception e) { throw new RuntimeException(e); }
        }
    }
}