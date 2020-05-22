public static double convertTimeUnit(double amount, TimeUnit from, TimeUnit to) {
    // is from or to the larger unit?
    if (from.ordinal() < to.ordinal()) { // from is smaller
        return amount / from.convert(1, to);
    } else {
        return amount * to.convert(1, from);
    }
}