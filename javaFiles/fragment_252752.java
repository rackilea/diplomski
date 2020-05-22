long x = 1234567890L;

long zeroLastNDigits(long x, long n) {
  long tenToTheN = Math.pow(10, n);
  return (x / tenToTheN) * tenToTheN;
}

zeroLastNDigits(x, 3) == 1234567000L;