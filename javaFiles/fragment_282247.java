public static void main(String[] args) {
    test("2x 1 piece");
    test("63x 9 pieces");
    test("4x 1 piece");
    test("1 piece");
    test("23 pieces");
}
private static void test(String input) {
    String regex = "(?:(\\d+)x\\s)?(\\d+)\\s(\\w*)";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(input);
    if (m.find()) {
        int multiplier = (m.group(1) != null ? Integer.parseInt(m.group(1)) : -1);
        int value = Integer.parseInt(m.group(2));
        String supplement = m.group(3);
        System.out.printf("%d, %d, '%s'%n", multiplier, value, supplement);
    }
}