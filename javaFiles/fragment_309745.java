enum OneTwo {
  one,
  two,
  three;

  BigInteger biValue() {
    BigInteger bi = BigInteger.ZERO;
    return bi.setBit(ordinal());
  }
  BigInteger biValue( BigInteger filter ) {
    BigInteger bi = BigInteger.ZERO;
    return bi.setBit(ordinal()).and(filter);
  }
}