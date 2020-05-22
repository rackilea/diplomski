int magicNumber2(int n, int a, int b, int c){
  if (n <= 1) return a;
  return magicNumber2(n - 1, b, c, a + b + c - 1);
}

int magicNumber(int n) {
  magicNumber2(n, 0, 1, 1);
}