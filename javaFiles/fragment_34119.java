public class SomeClass {
    public static <T> int codeAsInt(Class<T> type, T value) {
        // here you can use the type object
        if(type.isInstance(value)) {
        // ...
    }
    public static void main(String... args) {
        codeAsInt(Integer.class, 2);
        codeAsInt(Character.class, 'C');
        codeAsInt(String.class, "name");
    }
}