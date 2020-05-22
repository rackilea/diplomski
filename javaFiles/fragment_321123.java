public void readBytes( final byte[] out, final int offset, final int count, final ByteBuffer buffer ) {
      buffer.get( out, offset, count );  // udates ByteBuffer `position` automatically
   }

   public void readShorts( final short[] out, final int offset, final int count, final ByteBuffer buffer ) {
      ShortBuffer sb = buffer.asShortBuffer();
      sb.get( out, offset, count );  // note that `count` reads two bytes for each `short`
   }