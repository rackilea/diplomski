public abstract class Option<T> implements Iterable<T> {

    private static final Option NONE = new None();

    private Option() {
        // no-op
    }

    public static <T> Option<T> of(T t) {
        return t == null ? NONE : new Some<T>(t);
    }

    public static <T> Option<T> empty() {
        return NONE;
    }

    public abstract T get();

    public abstract T orElse(T fallback);

    public abstract T orElse(Supplier<T> supplier);

    public abstract <E extends Exception> T orThrow(Supplier<E> exceptionSupplier) throws E;

    public abstract boolean isPresent();

    public abstract Option<T> filter(Predicate<T> predicate);

    public abstract void ifPresent(Consumer<T> consumer);

    public abstract <O> Option<O> ifPresent(Function<T, O> function);

    private static final class Some<T> extends Option<T> {

        private final T value;

        private Some(final T value) {
            this.value = value;
        }

        @Override
        public T get() {
            return value;
        }

        @Override
        public T orElse(final T fallback) {
            return value;
        }

        @Override
        public T orElse(final Supplier<T> supplier) {
            return value;
        }

        @Override
        public <E extends Exception> T orThrow(final Supplier<E> exceptionSupplier) throws E {
            return value;
        }

        @Override
        public boolean isPresent() {
            return true;
        }

        @Override
        public Option<T> filter(final Predicate<T> predicate) {
            return predicate.test(value) ? this
                                         : NONE;
        }

        @Override
        public void ifPresent(final Consumer<T> consumer) {
            consumer.consume(value);
        }

        @Override
        public <O> Option<O> ifPresent(final Function<T, O> function) {
            return Option.of(function.apply(value));
        }

        @Override
        public Iterator<T> iterator() {
            return Collections.singletonList(value).iterator();
        }
    }

    private static final class None<T> extends Option<T> {
        @Override
        public T get() {
            throw new IllegalStateException("value not defined");
        }

        @Override
        public T orElse(final T fallback) {
            return fallback;
        }

        @Override
        public T orElse(final Supplier<T> supplier) {
            return supplier.get();
        }

        @Override
        public <E extends Exception> T orThrow(final Supplier<E> exceptionSupplier) throws E {
            throw exceptionSupplier.get();
        }

        @Override
        public boolean isPresent() {
            return false;
        }

        @Override
        public Option<T> filter(final Predicate<T> predicate) {
            return this;
        }

        @Override
        public void ifPresent(final Consumer<T> consumer) {
            // no-op
        }

        @Override
        public <O> Option<O> ifPresent(final Function<T, O> function) {
            return NONE;
        }

        @Override
        public Iterator<T> iterator() {
            return Collections.<T>emptyList().iterator();
        }
    }
}