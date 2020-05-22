static void test(String input) {
    Pattern p = Pattern.compile("\\((\\d+)\\)");
    Matcher m = p.matcher(input);
    int sum = 0;
    while (m.find()) {
        sum += Integer.parseInt(m.group(1));
    }
    System.out.println(sum);
}
public static void main(String[] args) {
    test("T2(23)");             // prints: 23
    test("T2(123)");            // prints: 123
    test("T2(23)K3(11)");       // prints: 34
    test("T2(23)K3(11)U4(42)"); // prints: 76
}