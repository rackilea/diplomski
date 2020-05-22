class NoHeaderObjectOutputStream extends ObjectOutputStream {
  public NoHeaderObjectOutputStream(OutputStream os) {
    super(os);
  }
  protected void writeStreamHeader() {}
}