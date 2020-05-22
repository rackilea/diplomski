public class ThreadSingletonFactory<T> implements Factory<T> {

    private final ThreadLocal<T> instance;

    public ThreadSingletonFactory(final Factory<T> factory) {
        this.instance = new ThreadLocal<T>() {
            @Override
            protected T initialValue() {
                return factory.create();
            }
        };
    }

    @Override
    public T create() {
        return instance.get();
    }
}