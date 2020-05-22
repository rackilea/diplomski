public class Foo {
  private String fooName;
  private Bar barObject;
  private ExternalService externalService;

  @Inject
  public Foo(
      @Assisted String fooName,
      @Assisted Bar barObject,
      ExternalService externalService) {
    this.fooName = fooName;
    this.barObject = barObject;
    this.externalService = externalService;
  }

  public interface FooFactory {
    Foo create(String fooName, Bar barObject);
  }
}