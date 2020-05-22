public class MyClass extends SuperDuperClass {

  public MyClass() {
    this(convert("Foo!"));  // convert will be executed 
                            // other constructor is called
  }

  public MyClass(String arg) {
    super(convert(arg));  // convert will be executed 
                          // before superconstructor is called
  }

  private static String convert(String arg) {
    return arg + "_modified";
  }
}