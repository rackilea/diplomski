private static double calculateRatePower(double rate, int period) {
  return Math.pow(1.0 + rate/12.0, period * 12.0);
}

public static void main(String[] args) throws IOException {
  double iRate = 0.06;
  double borrowAmount = 100000.0;
  int loanTerm = 15;

  double top = (iRate / 12.0) * calculateRatePower(iRate, loanTerm);
  double bottom = 1 - calculateRatePower(iRate, loanTerm);

  double repayments = borrowAmount * (top/bottom);
  System.out.println(repayments);
}