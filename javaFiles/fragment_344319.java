public static void main(String[] args) {
    test("PREFIX=fOo1234bar");
    test("PREFIX(-1.23456)=SomeString");
    test("PREFIX(0.20)=1A2b3C");
    test("sadfsahlhjladf");
}
private static void test(String text) {
    Pattern p = Pattern.compile("PREFIX(?:\\(([+-]?(?:\\d+\\.?\\d*|\\.\\d+))\\))?=(\\S*)");
    Matcher m = p.matcher(text);
    if (! m.matches())
        System.out.println("<do nothing>");
    else if (m.group(1) == null)
        System.out.println("'" + m.group(2) + "'");
    else
        System.out.println(Double.parseDouble(m.group(1)) + ", '" + m.group(2) + "'");
}