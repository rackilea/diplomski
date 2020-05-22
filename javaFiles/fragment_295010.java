public static void main(final String... args) {
    p("0");
    p("0.0");
    p("1.0");
    p("1.00");
    p("1");
    p("11.0");
}

private static void p(String s) {
    BigDecimal stripped = new BigDecimal(s).stripTrailingZeros();
    System.out.println(s + " - scale: " + new BigDecimal(s).scale()
        + "; stripped: " + stripped.toPlainString() + " " + stripped.scale());
}

0 - scale: 0; stripped: 0 0
0.0 - scale: 1; stripped: 0.0 1
1.0 - scale: 1; stripped: 1 0
1.00 - scale: 2; stripped: 1 0
1 - scale: 0; stripped: 1 0
11.0 - scale: 1; stripped: 11 0