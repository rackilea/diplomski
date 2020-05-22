public class Test<T> {

    public T createCopy(T item) throws Exception {// here should be
        // thrown more detailed exceptions but I decided to reduce them for
        // readability

        Class<?> clazz = item.getClass();
        Constructor<?> copyConstructor = clazz.getConstructor(clazz);

        @SuppressWarnings("unchecked")
        T copy = (T) copyConstructor.newInstance(item);

        return copy;
    }
}