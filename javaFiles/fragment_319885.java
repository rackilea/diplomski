public static void main(String[] args) {
    System.out.println("part1 op1   part2 op2   part3   a  b  c  input");
    test("3x^2 + 4x + 5");
    test("x^2 + x + 1");
    test("x^2 - 4x");
    test("-x^2 - 1");
    test("-4x - 5");
    test("-3x^2");
    test("-4x");
    test("-5");
    test("");
    test("-3x^2 + -1x");
}
private static void test(String input) {
    String regex = "(?!$)" +
                   "(?:(-?\\d*)x\\^2)?" +
                   "(?:(?<=2)\\s*([+-])\\s*(?!-|^))?" +
                   "(?:(?<!2)(-?\\d*)x)?" +
                   "(?:(?<=[2x])\\s*([+-])\\s*(?!-|^))?" +
                   "(?:(?<![2x])(-?\\d+))?";
    Matcher m = Pattern.compile(regex).matcher(input);
    if (! m.matches()) {
        System.out.printf("%-41s\"%s\"%n", "No match", input);
    } else {
        String part1 = m.group(1);
        String op1   = m.group(2);
        String part2 = m.group(3);
        String op2   = m.group(4);
        String part3 = m.group(5);
        long a = parse(null, part1);
        long b = parse(op1, part2);
        long c = parse((op2 != null ? op2 : op1), part3);
        System.out.printf("%-6s%-6s%-6s%-6s%-6s%3d%3d%3d  \"%s\"%n",
                          (part1 == null ? "" : '"' + part1 + '"'),
                          (op1   == null ? "" : '"' + op1   + '"'),
                          (part2 == null ? "" : '"' + part2 + '"'),
                          (op2   == null ? "" : '"' + op2   + '"'),
                          (part3 == null ? "" : '"' + part3 + '"'),
                          a, b, c, input);
    }
}
private static long parse(String operator, String signedNumber) {
    long number;
    if (signedNumber == null)
        number = 0;
    else if (signedNumber.isEmpty())
        number = 1;
    else if (signedNumber.equals("-"))
        number = -1;
    else
        number = Long.parseLong(signedNumber);
    if ("-".equals(operator))
        number = -number;
    return number;
}