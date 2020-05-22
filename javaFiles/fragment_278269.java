public class DrainableOutputStream extends FilterOutputStream {
  private final ByteArrayOutputStream buffer;
  public DrainableOutputStream(OutputStream out) {
    super(out);
    this.buffer = new ByteArrayOutputStream();
  }
  @Override
  public void write(byte b[]) throws IOException {
    this.buffer.write(b);
    super.write(b);
  }
  @Override
  public void write(byte b[], int off, int len) throws IOException {
    this.buffer.write(b, off, len);
    super.write(b, off, len);
  }
  @Override
  public void write(int b) throws IOException {
    this.buffer.write(b);    
    super.write(b);
  }
  public byte[] toByteArray() {
    return this.buffer.toByteArray();
  }
}