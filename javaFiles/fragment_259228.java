private static BigDecimal divideAndRound(BigInteger bdividend, BigInteger bdivisor, int scale, int roundingMode,
                                         int preferredScale) {
    boolean isRemainderZero; // record remainder is zero or not
    int qsign; // quotient sign
    // Descend into mutables for faster remainder checks
    MutableBigInteger mdividend = new MutableBigInteger(bdividend.mag);
    MutableBigInteger mq = new MutableBigInteger();
    MutableBigInteger mdivisor = new MutableBigInteger(bdivisor.mag);
    MutableBigInteger mr = mdividend.divide(mdivisor, mq);
    ...