byte[] bytes = ...
ByteBuffer buffer = ByteBuffer.wrap( bytes );

// you may or may not need to do this
//buffer.order( ByteOrder.BIG/LITTLE_ENDIAN );

ShortBuffer shorts = buffer.asShortBuffer( );

for ( int i = 0, n=shorts.remaining( ); i < n; ++i ) {
    final int index = shorts.position( ) + i;

    // Perform your transformation
    final short adjusted_val = shortAdjuster( shorts.get( index ) );

    // Put value at the same index
    shorts.put( index, adjusted_val );
}

// bytes now contains adjusted short values