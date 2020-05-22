byte[] longToByteArray(long x) {
    byte[] array = new byte[8];
    for (int i = 7; i >= 0; i--) {
        array[i] = (byte)x;
        x >>>= 8;
    }
}