String bitString(int n, int numBits) {
    StringBuffer ret = new StringBuffer(numBits);
    for(int i = numBits; i > 0; i--) {
          ret.append((n>>>(i-1))&1);
    }
    return ret.toString();
}