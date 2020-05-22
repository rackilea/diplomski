public class SyntheticConstructor {
    private SyntheticConstructor() {}
    class Inner {
       Inner() { new SyntheticConstructor(); }
    }
}