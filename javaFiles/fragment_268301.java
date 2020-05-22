public class Class1 {
    public Class1(int arg) { ... }
    public Class1(String arg) { ... }
}

public class Class2 {
    public Class2() {
        // The body MUST start with this "super" statement:
        super(<something>);
        // where the argument can be converted to an int or String, or else it's
        // an error!  (Exception: it can start with a this() to call another constructor
        // defined for Class2.)
    }
}