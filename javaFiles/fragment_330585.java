public class TestProducer {

  @Produces @TestQualifier
  public String createString(InjectionPoint ip) {
    if(something) {
      return "a String";
    } else {
      // Some other value
    }
  }

  @Produces @TestQualifier
  public int createInt(InjectionPoint ip) {
    if(something) {
      return 42;
    } else {
      // Some other value
    }
  }
// ...