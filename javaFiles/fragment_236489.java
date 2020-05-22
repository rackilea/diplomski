public final class FunctionCombinator<T,U,R> implements Function<T,R> {
    final Function<? super T,? extends U> first;
    final Function<? super U,? extends R> second;

    public FunctionCombinator(
        Function<? super T,? extends U> f1, Function<? super U,? extends R> f2) {
        first = f1;
        second = f2;
    }

    @Override
    public R apply(T t) {
        return second.apply(first.apply(t));
    }

    @Override
    public <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        return newCombinator(this, after);
    }

    @Override
    public <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        return newCombinator(before, this);
    }

    @SuppressWarnings("unchecked")
    public static <A,B,C> Function<A,C> newCombinator(
        Function<? super A,? extends B> f1, Function<? super B,? extends C> f2) {

        Objects.requireNonNull(f1);
        Objects.requireNonNull(f2);

        URL u = FunctionCombinator.class.getProtectionDomain()
            .getCodeSource().getLocation();
        try(URLClassLoader cl = new URLClassLoader(new URL[] { u }, null)) {
            return cl.loadClass(FunctionCombinator.class.getName())
                .asSubclass(Function.class)
                .getConstructor(Function.class, Function.class)
                .newInstance(f1, f2);
        }
        catch(IOException | ReflectiveOperationException ex) {
            throw new IllegalStateException(ex);
        }
    }
}