public class DecimalScientificFormat extends DecimalFormat {
    private static DecimalFormat df = new DecimalFormat("#0.00##");
    private static DecimalFormat sf = new DecimalFormat("0.###E0");

    @Override
    public StringBuffer format(double number, StringBuffer result, FieldPosition fieldPosition) {
        String decimalFormat = df.format(number);
        return (0.0001 != number && df.format(0.0001).equals(decimalFormat)) ? sf.format(number, result, fieldPosition) : result.append(decimalFormat);
    }
}