class Bits {
    final BitSet bitset;
    final int nbits;

    Bits(BitSet bitset, int nbits) {
        this.bitset = bitset;
        this.nbits = nbits;
    }

    int[] values() {
        int[] v = new int[nbits];
        for (int i = bitset.nextSetBit(0); i >= 0; i = bs.nextSetBit(i + 1)) {
            v[i] = 1;
        }
        return v;
    }
}