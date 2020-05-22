public class MyInputStream extends FilterInputStream {
  public MyInputStream(InputStream in) {
    super(in);
  }

  @Override 
  public void close() {
    // do nothing
  }
}