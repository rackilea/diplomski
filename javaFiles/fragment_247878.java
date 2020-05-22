private static void test(String input) {
    String regex = "^application\\.(.*)\\.\\d";
    Matcher m = Pattern.compile(regex).matcher(input);
    if (m.find())
        System.out.println(input + ": Found \"" + m.group(1) + "\"");
    else
        System.out.println(input + ": **NOT FOUND**");
}
public static void main(String[] args) {
    test("application.APPLICATION NAME.123456789.status");
    test("application.Other.App.Name.123456789.status");
    test("application.App 55 name.123456789.status");
    test("application.App.55.name.123456789.status");
    test("bad input");
}