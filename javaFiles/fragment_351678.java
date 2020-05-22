public class GenericClass<T> {

    public T method1(T obj, Class<T> clazz) {
        System.out.println(obj);
        return obj;
    }

    public <U extends T> U method2(U obj, Class<U> clazz) {
        System.out.println(obj);
        return obj;
    }
}