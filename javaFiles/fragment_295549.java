private byte[] solveChallenge(int[] dummyData, int offset, int level) {
    int[] x = Arrays.copyOfRange(dummyData, 00 + offset, 65 + offset);
    int[] n = Arrays.copyOfRange(dummyData, offset, 65 + offset + 64);
    n[0] = 0; //null first byte in n, don't copy this line, this only works for my problem!
    BigInteger xInt = this.toBigInteger(x, offset);
    BigInteger nInt = this.toBigInteger(n, offset);
    BigInteger inner = pow(BigInteger.valueOf(2), BigInteger.valueOf(level));
    return xInt.modPow(inner, nInt).toByteArray();
}
private BigInteger pow(BigInteger base, BigInteger exponent) {
      BigInteger result = BigInteger.ONE;
      while (exponent.signum() > 0) {
        if (exponent.testBit(0)) result = result.multiply(base);
        base = base.multiply(base);
        exponent = exponent.shiftRight(1);
      }
      return result;
}
private BigInteger toBigInteger(int[] data, int offset, int length) {
    byte[] array = new byte[data.length * 4];
    ByteBuffer bbuf = ByteBuffer.wrap(array);
    IntBuffer ibuf = bbuf.asIntBuffer();
    ibuf.put(data);
    bbuf.order(ByteOrder.BIG_ENDIAN);
    int i = 0;
    byte[] newArr = new byte[(array.length / 4)-1];
    //convert to Little-Endian like systems and only keep every fourth byte
    for(int j = 0; j < array.length-1; ++j) {
        if(j % 4 == 0 && j > 0) {
            int pos = j - 1;
            newArr[i] = array[pos]; 
            ++i;
        }
    }
    return new BigInteger(1, newArr);
}