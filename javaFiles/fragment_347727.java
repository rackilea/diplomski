ByteBuffer buf = ButeBuffer.wrap( bytes );
buf.order( ByteOrder.BIG_ENDIAN );

while ( buf.hasRemaining() ) {
    int num = buf.getInt();
    // do something with num...
}