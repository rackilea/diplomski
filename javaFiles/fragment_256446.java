public enum Round {;
    public static double round(final double x, final int decimalPrecision) {
        round(x, decimalPrecision, Math::rint);
    }
    public static double roundUp(final double x, final int decimalPrecision) {
        round(x, decimalPrecision, Math::ceil);
    }
    public static double roundDown(final double x, final int decimalPrecision) {
        round(x, decimalPrecision, Math::floor);
    }
    public static double round(final double x, final int decimalPrecision, final Function<Double, Double> round) {
        return round.apply(x * decimalPrecision) / decimalPrecision);
    }
}