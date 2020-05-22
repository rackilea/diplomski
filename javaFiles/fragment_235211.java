private static String format2Dp(double x) {
    String d = Double.toString(x);
    Matcher m = Pattern.compile("\\.(\\d+)").matcher(d);
    if (!m.find()) {
        return d;
    }
    String decimalPart = m.group(1);
    if (decimalPart.length() == 1) {
        return d.replaceAll("\\.(\\d+)", "." + decimalPart + "0");
    }
    return d.replaceAll("\\.(\\d+)", "." + decimalPart.substring(0, 2));
}