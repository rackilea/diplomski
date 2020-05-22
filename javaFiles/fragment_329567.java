// LimitedChannel.java
// private int bytesLeft; // remaining amount of bytes to read
public int read(ByteBuffer buffer) {
  if (bytesLeft <= 0) {
    return -1;
  }
  int oldLimit = buffer.limit();
  if (bytesLeft < buffer.remaining()) {
    // ensure I'm not reading more than allowed
    buffer.limit(buffer.position() + bytesLeft);
  }
  int bytesRead = delegateChannel.read(buffer);
  bytesLeft -= bytesRead;
  buffer.limit(oldLimit);
  return bytesRead;
}