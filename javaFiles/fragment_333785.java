class BigDecimalExperiment {
    static boolean isEverythingAfterTwoDigitsZero(BigDecimal bd) {
        return (bd.compareTo(bd.setScale(2, RoundingMode.DOWN)) == 0);
    }

    public static void main(String[] args) {
        List<BigDecimal> values = Arrays.asList(
                new BigDecimal("7.5"),
                new BigDecimal("7.50000"),
                new BigDecimal("7.50000001"),
                new BigDecimal("75.01"),
                new BigDecimal(75.01),
                new BigDecimal("75.0100000"),
                new BigDecimal("75.0100001")
        );
        for (BigDecimal value : values) {
            System.out.printf("%s\t%s%n", isEverythingAfterTwoDigitsZero(value), value);
        }
    }
}