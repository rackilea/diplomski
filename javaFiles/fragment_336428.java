public static abstract class AbstractBuilder<T extends AbstractBuilder<T>> {
    protected String name;

    private final Class<T> clazz;

    public AbstractBuilder(Class<T> clazz) {
        this.clazz = clazz;
    }

    protected abstract T self();

    private T confusing() throws Exception {
        return clazz.newInstance();
    }

    public T setName(String name) {
        this.name = name;
        return self();
    }
}