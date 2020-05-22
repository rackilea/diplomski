public class DecimalFormatTest extends TestCase {
    private static class MyFormat extends NumberFormat {
        private final DecimalFormat decimal;

        public MyFormat(String pattern) {
            decimal = new DecimalFormat(pattern);
        }

        public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
            StringBuffer sb = new StringBuffer();
            sb.append(modified(Math.abs(number) > 1.0, decimal.format(number, toAppendTo, pos).toString()));
            return sb;
        }

        private String modified(boolean large, String s) {
            return large ? s.replace("E", "E+") : s;
        }

        public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
            StringBuffer sb = new StringBuffer();
            sb.append(modified(true, decimal.format(number, toAppendTo, pos).toString()));
            return sb;
        }

        public Number parse(String source, ParsePosition parsePosition) {
            return decimal.parse(source, parsePosition);
        }

        public void setPositivePrefix(String newValue) {
            decimal.setPositivePrefix(newValue);
        }
    }
    private MyFormat    format;

    protected void setUp() throws Exception {
        format = new MyFormat("0.0E0");
        format.setPositivePrefix("+");
    }

    public void testPositiveLargeNumber() throws Exception {
        assertEquals("+1.0E+2", format.format(100.0));
    }

    public void testPositiveSmallNumber() throws Exception {
        assertEquals("+1.0E-2", format.format(0.01));
    }

    public void testNegativeLargeNumber() throws Exception {
        assertEquals("-1.0E+2", format.format(-100.0));
    }

    public void testNegativeSmallNumber() throws Exception {
        assertEquals("-1.0E-2", format.format(-0.01));
    }
}