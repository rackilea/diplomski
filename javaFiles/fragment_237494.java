public abstract class Model <T> {
    public static <T> T find(Class<T> clazz, int id) {
        T result = (T) blackMagicMethod(clazz, id);
        return result;
    }
}