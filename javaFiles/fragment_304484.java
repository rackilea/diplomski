public interface AdapterFunction<T, R>
                                      extends
                                          java.util.function.Function<T, R>,
                                          com.google.common.base.Function<T, R> {
    @Override
    default R apply(T input) {
        return null;
    }
}