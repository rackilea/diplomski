public abstract class a<T> {

    private Class<T> clazz;
    private T element;

    public a(T obj) {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>) type.getActualTypeArguments()[0];
        this.element = obj;
    }
}

class StringA extends a<String> {
    public StringA(String obj) {
        super(obj);
    }
}