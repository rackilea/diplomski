public static String format(double d, int numDecimalPlaces, int numExponentDigits) {
    StringBuilder sb = new StringBuilder("0.%0");

    sb.append(numDecimalPlaces);
    sb.append("d");
    sb.append("E");
    sb.append("%0");
    sb.append(numExponentDigits);
    sb.append("d");

    return new DecimalFormat(String.format(sb.toString(), 0, 0)).format(d);
}