public static void main(String[] args)
  {
    System.out.print(RecursiveDivision(100,3));
  }

  public static double RecursiveDivision(double dividend, int divisor) {
    if (dividend < 1)
      return dividend;

    return RecursiveDivision(dividend/divisor, divisor);
  }