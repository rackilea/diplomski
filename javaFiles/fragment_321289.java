ByteBuffer originalBuffer = getOriginalBuffer();
ByteBuffer newBuffer = ByteBuffer.allocate(originalBuffer.limit());

ByteBuffer slicedBuffer = originalBuffer.slice(); //Will be from pos to end
originalBuffer.flip(); //Will be from 0 to pos

newBuffer.put(slicedBuffer)
newBuffer.put(originalBuffer)