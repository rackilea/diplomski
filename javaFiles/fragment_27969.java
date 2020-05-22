int compare(BitSet lhs, BitSet rhs) {
    if (lhs.equals(rhs)) return 0;
    BitSet xor = (BitSet)lhs.clone();
    xor.xor(rhs);
    int firstDifferent = xor.length()-1;
    if(firstDifferent==-1)
            return 0;

    return rhs.get(firstDifferent) ? 1 : -1;
}