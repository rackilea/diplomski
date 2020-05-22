static String REGEX = "([^\"\\\\]|\\\\[^\\\\]+|\\\\\\\\)+";

public static void main(String[] args) {

    test("\"");
    test("\\");
    test("\\\\\\");
    System.out.println();
    test("\\\"");
    test("\\r");
    test("\\ ");
    test("\\\\\\cloud");
    test("\\\\\\ ");
    test("clo$d");
    test("cloud space");
}

public static void test(String s) {
    System.out.println(s + ": " + REGEX + " " + Pattern.matches(REGEX, s));
}