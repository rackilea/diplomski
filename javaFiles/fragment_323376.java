@Dependent // make your custom context a CDI-bean
public class MyCustomContext {

  @Inject // inject predefined CDI-bean
  private HttpServletRequest request;
}