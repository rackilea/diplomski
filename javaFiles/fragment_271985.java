static final BigDecimal SQRT_5 = BigDecimal.valueOf(Math.sqrt(5));
static final BigDecimal GR = (BigDecimal.ONE.add(SQRT_5).divide(BigDecimal.valueOf(2));
static final BigDecimal NGR = GR.negate().add(BigDecimal.ONE);

// Binet algorithm
private static long fibGoldenRatio(int n) {

  if (n < 0) {
     return -1;
  }

  return BigDecimal.ONE.divide(SQRT_5).multiply((GR.pow(n).substract(NGR.pow(n)))).toBigInteger().longValue();
}