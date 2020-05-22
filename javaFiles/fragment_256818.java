public class TestClass {

  public void doSomethingWithTestEnum(TestEnum testEnum) {
    switch (testEnum) {
    case TEST1:
      // do something here
      break;
    case TEST2:
      // do something here
      break;
    default:
      throw new IllegalArgumentException("Unknown enum type: " + testEnum);
    }
  }

}