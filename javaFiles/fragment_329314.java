public static void main(String[] args) {
    BigDecimal value = new BigDecimal("2.0");
    BigDecimal significance = new BigDecimal("0.5");
    for (int i = 1; i <= 10; i++) {
        System.out.println(value + " --> " + floor(value, significance));
        value = value.add(new BigDecimal("0.1"));
    }
}

private static double floor(BigDecimal value, BigDecimal significance) {
    double result = 0;
    if (value != null) {
        result = value.divide(significance).doubleValue();
        result = Math.floor(result) * significance.doubleValue();
    }
    return result;
}