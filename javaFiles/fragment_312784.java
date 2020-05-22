long l = new BigDecimal("-9223372036854775808.2")
                   .setScale(0, RoundingMode.HALF_EVEN)
                   .longValueExact(); // ok, -9223372036854775808

long l = new BigDecimal("-9223372036854775808.9")
                   .setScale(0, RoundingMode.HALF_EVEN)
                   .longValueExact(); // ArithmeticException