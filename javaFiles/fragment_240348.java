String[] tests = {
        "100.33", "100.12", "100.66", "100.99", "100.70", "100.00", "100.25",
    };
    final BigDecimal FOUR = BigDecimal.valueOf(4);
    for (String test : tests) {
        BigDecimal d = new BigDecimal(test);
        d = d.multiply(FOUR).setScale(0, RoundingMode.UP)
             .divide(FOUR, 2, RoundingMode.UNNECESSARY);
        System.out.println(d);
    }