private static byte[] bitsToBytes(byte[] bits) {
  BitSet bitSet = new BitSet();
  for (int i = 0; i < bits.length; i++) {
    bitSet.set(i, bits[i] == 1);
  }
  return bitSet.toByteArray();
}