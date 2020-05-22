private int mostSignificantBit(int myInt){
  int mask = 1 << 31;
  for(int bitIndex = 31; bitIndex >= 0; bitIndex--){
    if((myInt & mask) != 0){
      return bitIndex;
    }
    mask >>>= 1;
  }
  return -1;
}