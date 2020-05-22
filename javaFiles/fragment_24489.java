public static double simplify(Number n) {
    String numberString = String.format("%e", n);
    int indexE = numberString.indexOf('e');
    String baseValue = numberString.substring(0, indexE);
    String exponent = numberString.substring(indexE + 1);
    double base = Double.parseDouble(baseValue);
    int    exp = Integer.parseInt(exponent);

    return base * Math.pow(10, exp);
}