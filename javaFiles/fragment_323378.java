@Dependent // make your custom context a CDI-bean
public class MyCustomContext {

  //@Context // in non JAX-RS context the instance will be null
  @Inject // instead inject the JAX-RS context instance via CDI
  private Request request;
}