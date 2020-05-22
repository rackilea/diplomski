public static int[] unpackNStar ( byte[] bytes ) {
    // first, wrap the input array in a ByteBuffer:
    ByteBuffer byteBuf = ByteBuffer.wrap( bytes );

    // then turn it into an IntBuffer, using big-endian ("Network") byte order:
    byteBuf.order( ByteOrder.BIG_ENDIAN );
    IntBuffer intBuf = byteBuf.asIntBuffer();

    // finally, dump the contents of the IntBuffer into an array
    int[] integers = new int[ intBuf.remaining() ];
    intBuf.get( integers );
    return integers;
}