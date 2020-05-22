public static int[] getOneBits(int num) {
    int[] oneBits = new int[Integer.bitCount(num)];
    for (int i = 0; i < oneBits.length; i++) {
        oneBits[i] = Integer.highestOneBit(num);
        num ^= oneBits[i];
    }
    return oneBits;
}