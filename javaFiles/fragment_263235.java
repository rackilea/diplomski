public static BitSet convertTo (BigInteger bi) {
    byte[] bia = bi.toByteArray();
    int l = bia.length;
    byte[] bsa = new byte[l+1];
    System.arraycopy(bia,0,bsa,0,l);
    bsa[l] = 0x01;
    return BitSet.valueOf(bsa);
}

public static BigInteger convertFrom (BitSet bs) {
    byte[] bsa = bs.toByteArray();
    int l = bsa.length-0x01;
    byte[] bia = new byte[l];
    System.arraycopy(bsa,0,bia,0,l);
    return new BigInteger(bia);
}