public static void main(String[] args) {
    test("%d");
    test("%+d");
    test("% d");
    test("%(d");
    test("%+ d");
    test("%+(d");
    test("% (d");
    test("%+ (d");
}
private static void test(String fmt) {
    try {
        System.out.printf("%5s: '" + fmt + "'%n", fmt, 14);
        System.out.printf("%5s: '" + fmt + "'%n", fmt, -14);
    } catch (Exception e) {
        System.out.printf("%5s: %s%n", fmt, e);
    }
}