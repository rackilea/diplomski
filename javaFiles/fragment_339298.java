public class Main {
    public static void main(String... args) throws ClassNotFoundException {
        class LocalClass {}

        System.out.println(Class.forName(name(StaticNestedClass.class))); //static nested class
        System.out.println(Class.forName(name(InnerClass.class))); // inner class
        System.out.println(Class.forName(name(Integer[].class))); // object array
        System.out.println(Class.forName(name(int[].class))); // primitive array
        System.out.println(Class.forName(name(List.class))); // interface
        System.out.println(Class.forName(name(LocalClass.class))); // local class
        System.out.println(Class.forName(name(new Object(){}.getClass()))); // anonymous class
    }

    private static String name(Class<?> clazz) {
        return clazz.getName();
    }

    public static class StaticNestedClass {}
    public class InnerClass {}
}