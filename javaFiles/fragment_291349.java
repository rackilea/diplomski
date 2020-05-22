public static void main(String[] args) throws Exception
{
    test("3.95e-06");
    test("12345");
}

private static void test(String line) throws Exception {
    DecimalFormat bdf = new DecimalFormat();
    double d = bdf.parse(line.toUpperCase()).doubleValue();
    System.out.println(d);
    bdf.setParseBigDecimal(true);
    BigDecimal test = (BigDecimal) bdf.parse(line.toUpperCase());
    System.out.println(test);
}