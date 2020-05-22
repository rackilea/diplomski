public static boolean isBigDecimalDifferent(BigDecimal x, BigDecimal y) {
    if (x == null) {
        return y != null;
    }
    if (y == null) {
        return x != null;
    }
    return x.compareTo(y) != 0;
}