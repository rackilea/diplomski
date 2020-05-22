double value = 1234567.9;
long l = BigDecimal.valueOf(value)
                   .setScale(0, RoundingMode.HALF_EVEN)
                   .longValueExact(); // 1234568

double value = 99999999999999999999999999999999.9;
long l = BigDecimal.valueOf(value)
                   .setScale(0, RoundingMode.HALF_EVEN)
                   .longValueExact(); // ArithmeticException