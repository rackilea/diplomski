@FunctionalInterface
public interface Function<T, R>
                                extends
                                    AdapterFunction<T, R> {

    R call(T input);

    @Override
    default R apply(T input) {
        return call(input);
    }
}