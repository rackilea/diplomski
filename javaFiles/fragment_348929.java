public static void main(String[] args) {
    test("key1=12345");
    test("key1=12345&key2=12345");
    test("key1=12345123456789");
    test("key1=12345123456789&key2=123456789");
}
private static void test(String input) {
    Matcher m = Pattern.compile("=([^&]{5})(?:&|$)").matcher(input);
    List<String> list = new ArrayList<>();
    while (m.find())
        list.add(m.group(1));
    System.out.println(list);
}