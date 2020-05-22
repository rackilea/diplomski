int mod(int base, int exponent, int modulus) {
  if (modulus == 1) return 0;
  int c = 1;
  for (int i = 0; i < exponent; i++) {
    c = (c * base) % modulus;
  }
  return c;
}