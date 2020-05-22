public static byte convert(BitSet bits, int offset) {
  byte value = 0;
  for (int i = offset; (i < bits.length() && ((i + offset) < 8)) ; ++i) {
    value += bits.get(i) ? (1 << i) : 0;
  }
  return value;
}