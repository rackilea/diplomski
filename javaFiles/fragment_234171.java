static String format(double n) {
    if(Double.isInfinite(n) || Double.isNaN(n))
        return Double.toString(n);
    String result = BigDecimal.valueOf(n).toPlainString();
    if(result.length() > 15)
        result = String.format("%.15e", n);
    return result;
}