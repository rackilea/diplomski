public long randomLong() {
  x ^= (x << 21);
  x ^= (x >>> 35);
  x ^= (x << 4);
  return x;
}