public class WriterHolder {

  public final static PrintWriter GLOBAL_WRITER = createWriter();

  private static PrintWriter createWriter() throws IOException {
   ... create and return that writer