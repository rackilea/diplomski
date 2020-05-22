public class InputStreamCollector {
  private InputStream is;

  public void collectInputStream(InputStream is) {
    if (this.is == null) this.is = is;
    this.is = new SequenceInputStream(this.is, is);
  }

  public InputStream getInputStream() {
    return this.is;
  }
}