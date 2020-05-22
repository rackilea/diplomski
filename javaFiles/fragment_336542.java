public static String ToEngineeringNotation(double d, String unit, int decimals) {
    String m = "";
    if (d > 1000000000) {
        d = d / 1000000000;
        m = " G";
    } else if (d > 1000000) {
        d = d / 1000000;
        m = " M";
    } else  if (d > 1000) {
        d = d / 1000;
        m = " K";
    }
    NumberFormat f = NumberFormat.getInstance();
    f.setGroupingUsed(false);
    f.setMinimumFractionDigits(decimals);
    f.setMaximumFractionDigits(decimals);
    return f.format(d) + m + " " + unit;
}