private static BigDecimal divide(BigInteger dividend, int dividendScale, BigInteger divisor, int divisorScale, int scale, int roundingMode) {
    if (checkScale(dividend,(long)scale + divisorScale) > dividendScale) {
        int newScale = scale + divisorScale;
        int raise = newScale - dividendScale;
        BigInteger scaledDividend = bigMultiplyPowerTen(dividend, raise);
        return divideAndRound(scaledDividend, divisor, scale, roundingMode, scale);
    } else {
        int newScale = checkScale(divisor,(long)dividendScale - scale);
        int raise = newScale - divisorScale;
        BigInteger scaledDivisor = bigMultiplyPowerTen(divisor, raise);
        return divideAndRound(dividend, scaledDivisor, scale, roundingMode, scale);
    }
}