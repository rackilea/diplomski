MappedByteBuffer fileBuf = FileChannel.map(....);

ByteBuffer header  = ...;
ByteBuffer trailer = ...;
ByteBuffer slice   = fileBuf.slice(); // Set limit and position before slice

socketChannel.write(new ByteBuffer[]{header, slice, trailer}, 0, 3);