public class Generics {

    public static void main(String[] args) {
        Generics.<Integer>method(Integer.class).intValue();
    }

    public static <T> T method(Class<T> t) {
        return (T) new String();
    }
}