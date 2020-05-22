private static byte[] bytesToBits(int nbits, byte[] bits) {
  BitSet bitSet = BitSet.valueOf(bits);
  byte[] result = new byte[nbits];
  for (int i = 0; i < result.length; i++) {
    result[i] = (byte) (bitSet.get(i) ? 1 : 0);
  }
  return result;
}