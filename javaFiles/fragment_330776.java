public class Main {

    public static class GenericClass<T> {
        public void foo(Class<Integer> clazz) {
        }
    }

    public static void main(String... args) {
        GenericClass unsafeInstance = new GenericClass();
        unsafeInstance.foo(String.class);
    }
}