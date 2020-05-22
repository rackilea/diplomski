public static void main(String[] args) {
    test(4, 1);   // expected: 0001
    test(3, 20);  // expected: 020
    test(6, 12);  // expected: 000012
    test(6, 179); // expected: 000179
    test(2, 19);  // expected: 19
}
private static void test(int len, int value) {
    String s1 = String.format("%0" + len + "d", value);

    NumberFormat fmt = NumberFormat.getIntegerInstance();
    fmt.setMinimumIntegerDigits(len);
    fmt.setGroupingUsed(false);
    String s2 = fmt.format(value);

    System.out.printf("%-10s%s%n", s1, s2);
}