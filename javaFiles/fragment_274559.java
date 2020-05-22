public class SignificantFormat {

    public static String formatSignificant(double value, int significant)
    {
        MathContext mathContext = new MathContext(significant, RoundingMode.DOWN);
        BigDecimal bigDecimal = new BigDecimal(value, mathContext);
        return bigDecimal.toPlainString();
    }

    public static void main(String[] args) {
        double[] data = { 1, 100, 100000, 99999, 99999.99, 9999.99, 999.99, 23.34324 };
        for(double d: data){
            System.out.printf("Input: %10s \tOutput: %10s\n", Double.toString(d), formatSignificant(d, 5));
        }
    }
}