public class Simple {

    public static void main(String[] args) {

        String[] match = new String[]{"A", "D", "C"};
        System.out.println("1. " + matches("A-B-C-D", match));
        System.out.println("2. " + matches("B-C-A", match));
        System.out.println("3. " + matches("D-A", match));
        System.out.println("4. " + matches("B-A-D", match));
        System.out.println("5. " + matches("D-A-B-C", match));
    }

    public static boolean matches(String value, String... matches) {

        boolean doesMatch = true;
        for (String match : matches) {

            if (!value.contains(match)) {
                doesMatch = false;
                break;
            }

        }

        return doesMatch;

    }
}