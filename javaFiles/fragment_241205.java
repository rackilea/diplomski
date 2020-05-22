public class ControllerAction extends ActionSupport {

  private InputStream stream;

  //getter here
  public InputStream getStream() {
    return stream;
  }

  public String execute() throws Exception {
    String str = "sample string";
    stream = new ByteArrayInputStream(str.getBytes());
    return SUCCESS;
  }
}