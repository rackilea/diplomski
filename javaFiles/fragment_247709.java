private static BigDecimal ratePerMonth(double rate) {
  return BigDecimal.valueOf(rate).divide(BigDecimal.valueOf(12), 20, RoundingMode.DOWN);
}

private static BigDecimal calculateRatePower(double rate, int period) {
  BigDecimal onePlus = BigDecimal.ONE.add(ratePerMonth(rate));
  return onePlus.pow(period * 12);
}

public static void main(String[] args) throws IOException {
  double iRate = 0.06;
  double borrowAmount = 100000.0;
  int loanTerm = 15;

  BigDecimal top = ratePerMonth(iRate).multiply(calculateRatePower(iRate, loanTerm));
  BigDecimal bottom = BigDecimal.ONE.subtract(calculateRatePower(iRate, loanTerm));
  BigDecimal ratio = top.divide(bottom, 20, RoundingMode.DOWN);

  BigDecimal repayments = BigDecimal.valueOf(borrowAmount).multiply(ratio);
  System.out.println(repayments);
}