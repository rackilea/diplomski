private static BigInteger toBigInt(byte[] arr) {
    byte[] rev = new byte[arr.length + 1];
    for (int i = 0, j = arr.length; j > 0; i++, j--)
        rev[j] = arr[i];
    return new BigInteger(rev);
}