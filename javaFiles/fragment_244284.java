public static void main(String[] args) {
    test("1534251817666");
    test("2017-01-01");
    test("2017-01-01T00");
    test("2017-01-01T00:03");
    test("2017-01-01T00:03:00.5"); // modified
    test("2017-01-01T03:03:00+00:00");
    test("2017-01-01T03:03:00-05:00");
    test("2017-01-01T03:03:00+0500");
    test("2017-01-01T03:03:00Z");
    test("20170101T030300Z");
    test("2017-W01-1");
    test("2017W011");
    test("2017-001");
    test("2017001");
}
private static void test(String text) {
    Temporal parsed = parse(text);
    System.out.printf("%-25s -> %-25s %s%n", text, parsed, parsed.getClass().getSimpleName());
}