public abstract class Base<T extends Base<T>> {

    protected Base() {
        final Class<?> t = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        if (!t.isInstance(this)) {
            throw new IllegalArgumentException();
        }
    }

    public T getInstance() {
        @SuppressWarnings("unchecked")
        T thisIsT = (T) this;
        return thisIsT;
    }
}