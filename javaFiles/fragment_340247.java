public class MyAction extends ActionSupport {
  ...
  @Override
  public void validate() {
    setFieldErrors(null);
  }
}