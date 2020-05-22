public static void main(String[] args) {
    test(4, "FOUR", "");
    test(4, "FOUR", "Hello");
    test(4, "FOUR", "4");
    test(4, "FOUR", "1 2 3 4 5 6");
    test(4, "FOUR", "123456");
    test(4, "FOUR", "Test43");
}
private static void test(int num, String numText, String string) {
    System.out.println("\"" + string + "\" -> \"" + string.replace(num + "", numText) + "\"" +
                                          " = \"" + string.replace("" + num, numText) + "\"" +
                                          " = \"" + string.replace(String.valueOf(num), numText) + "\"");
}