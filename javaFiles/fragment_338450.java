public class Generics {

    public static void main(String[] args) {
        Generics.method(Integer.class).intValue();
    }

    public static Object method(Class<Object> t) {
        return (Object) new String();
    }
}