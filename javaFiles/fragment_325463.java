public static String fmt(final double d) {
    final double a = Math.abs(d);
    final boolean normal = a == 0 || a >= 1e-3 && a < 1e7;
    final DecimalFormat f = new DecimalFormat(normal ?
            "0.0##################" :
            "0.0#################E0");
    return f.format(d);
}