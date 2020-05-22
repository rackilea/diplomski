public class Main {

    public static void main(String[] args) {
        Subclass subclass = new Subclass();
        subclass.someString = "test";
        System.out.println(subclass);
    }

    private static class Base {

        public String someString;

    }

    private static class Subclass extends Base {

        public String someString;

    }
}