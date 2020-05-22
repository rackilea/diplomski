long x = 1234567890L;

long removeLastNDigits(long x, long n) {
  return x / Math.pow(10, n);
}

removeLastNDigits(x, 3) == 1234567L;