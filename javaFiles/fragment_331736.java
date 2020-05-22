import foo.*;       //import all classes from the package foo
import foo.bar.Baz; //import only the Baz class from the package foo.bar

public class MyClass {
    Baz myBaz = null;               //declare a member of type Baz class from package foo.bar
    foo.bar.BazBaz myBazBaz = null; //by using a fully qualified classname, I didn't need to write an import statement for foo.bar.BazBaz  
}