private static byte[] encodeToByteArray(int[] bits) {
    BitSet bitSet = new BitSet(bits.length);
    for (int index = 0; index < bits.length; index++) {
        bitSet.set(index, bits[index] > 0);
    }

    return bitSet.toByteArray();
}