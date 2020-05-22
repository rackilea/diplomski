public class ClassOne {

  public static class MyClass extends AnotherClass<ClassOne> {
    public MyClass(/* arguments you would pass in getThat()? */) {
      ...
    }
    ...
  }

  public static AnotherClass<ClassOne> getThat() {
    return new MyClass(...);
  }
}