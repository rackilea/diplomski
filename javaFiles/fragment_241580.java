public class ByteArrayWrapper {
  private byte [] bytes;
  private long readCount = 0;

  public ByteArrayWrapper( byte [] bytes ) {
    this.bytes = bytes;
  }

  public int getSize() { return bytes.length; }

  public byte getByte( int index ) { readCount++; return bytes[ index ]; }

  public long getReadCount() { return readCount; }
}