public class ThrowingSupplier {
    public static <T> Supplier<T> unchecked(Callable<T> callable) {
        return () -> {
            try {
                return callable.call();
            }
            catch (Exception e) {
                throw new UndeclaredThrowableException(e);
            }
        };
    }

    // example usage:
    public static void main(String[] args) {
        DataSource dataSource = null;
        Connection connection = ThrowingSupplier.unchecked(dataSource::getConnection).get();
    }
}