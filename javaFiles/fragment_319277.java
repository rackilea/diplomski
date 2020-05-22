@Component
public class SomeClass {
  @Autowired
  private Helper helper;

  public void someMethod() {
    // ...
    PropertyValue v = helper.getProperty(objId, propertyId);
    // ...
  }
}