public static boolean oddZeroes(int n) {
  if (n < 10) {
    return n == 0;
  }
  return (n % 10 == 0) ^ oddZeroes(n / 10);
}