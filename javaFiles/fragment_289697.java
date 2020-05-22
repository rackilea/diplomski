public class Memo<T> {
    private T result;
    private final Callable<T> callable;

    private boolean established;

    public Memo(final Callable<T> callable) {
        this.callable = callable;
    }

    public T get() {
        if (!established) {
            try {
                result = callable.call();
                established = true;
            }
            catch (Exception e) {
                throw new RuntimeException("Failed to get value of memo", e);
            }
        }
        return result;
    }
}