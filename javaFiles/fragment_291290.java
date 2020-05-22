public static final byte[] Long2ByteArray(long paramLong, ByteOrder paramByteOrder) {
    // create new byte array of the same size as a Java long (64 bit signed integer)
    byte[] arrayOfByte = new byte[8];
    // wrap it using a wrapper class
    ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
    // put it in LITTLE_ENDIAN order, (only effects the next put and get methods)
    localByteBuffer.order(paramByteOrder);
    // put in the long, where the least significant bits are in arrayOfByte[0]
    // and the most significant (as well as the sign bit) in arrayOfByte[7]
    // this is different from the default BIG_ENDIAN encoding used by Java
    localByteBuffer.putLong(paramLong);
    // return it
    return arrayOfByte;
}