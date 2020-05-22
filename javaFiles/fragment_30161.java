static void showBitsOf(BigInteger n) {
    if (n.compareTo(BigInteger.ZERO) < 0) {
        throw new IllegalArgumentException("n must not be negative");
    }
    BitSet bs = BitSet.valueOf(n.toByteArray());
    for (int i = bs.nextSetBit(0); i >= 0; i = bs.nextSetBit(i+1)) {
        System.out.println(i);
    }
}