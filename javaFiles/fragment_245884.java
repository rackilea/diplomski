public class Simple {

    public static void main(String[] args) {

        System.out.println("1. " + matches("A-B-C-D"));
        System.out.println("2. " + matches("B-C-A"));
        System.out.println("3. " + matches("D-A"));
        System.out.println("4. " + matches("B-A-D"));
        System.out.println("5. " + matches("D-A-B-C"));
    }

    public static boolean matches(String value) {

        return value.contains("A") && value.contains("C");

    }
}