public interface Function<T, R>
                                extends
                                    java.util.function.Function<T, R>,
                                    com.google.common.base.Function<T, R> {

    R call(T input);

    @Override
    default R apply(T input) {
        return call(input);
    }
}