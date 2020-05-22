public class SimpleClass<T> {
    private final Class<T> clazz;

    SimpleClass(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T getObject() throws IllegalAccessException, InstantiationException {
        // Should return a new object based on the class type
        return clazz.newInstance();
    }

}