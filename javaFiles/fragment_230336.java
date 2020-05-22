public class Test {

    public static void main(String[] args) {

        String input = "eye-of-tiger";
        String modified = dashToUpperCase(input);
        System.out.println(modified);
    }

    private static String dashToUpperCase(String input) {

        StringBuilder result = new StringBuilder();
        boolean toUpper = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-') {
                toUpper = true;
            } else {
                result.append(toUpper ? Character.toUpperCase(c) : c);
                toUpper = false;
            }
        }

        return result.toString();
    }
}