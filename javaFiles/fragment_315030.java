public class Clazz<T> {
    T t = (T) new Object();

    public static void main(String...args) {
        Clazz<String> clazz = new Clazz<String>();
        clazz.t.toString();
    }
}

Exception in thread "main" java.lang.ClassCastException: java.lang.Object cannot be cast to java.lang.String
    at Clazz.main(Clazz.java:6)
    ...