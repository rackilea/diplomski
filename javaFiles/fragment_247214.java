public static void main(String[] args) {
    test("key-keyone-keytwo");
    test("key-key-'one-keytwo");
    test("key-key'-one-keytwo");
    test("key-key'-'one-keytwo");
}
private static void test(String str) {
    String[] split = str.split("(?<!')-|-(?!')");
    System.out.println(Arrays.toString(split));
}