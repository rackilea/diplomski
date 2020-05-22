public class SomeClass {

  private SystemExiter exiter; // inject this or accept in constructor

  public void someMethod() {
    // ...

    exiter.exit(1);
  }
}