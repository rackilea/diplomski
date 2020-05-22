public class MyGenericType<T extends EntityClass> {

    private final Class<T> genericClazz;

    public MyGenericType(Class<T> clazz) {
        this.genericClazz = clazz;
    }

    @Override
    public String toString() {
        return this.genericClazz.getSimpleName();
    }
}