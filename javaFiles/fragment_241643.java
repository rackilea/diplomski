BigDecimal zero = BigDecimal.ZERO;
if (someBigDecimal.compareTo(zero) == 0) {
    someBigDecimal = zero;
} else {
    someBigDecimal = someBigDecimal.stripTrailingZeros();
}