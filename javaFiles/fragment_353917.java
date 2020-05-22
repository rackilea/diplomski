public class MyClassFactory {

    private final DepA depA;
    private final DepB depB;

    public MyClassFactory(DepA depA, DepB depB) {
        this.depA = depA;
        this.depB = depB;
    }

    public MyClass createMyClass(String aContextualValue) {
        return new MyClass(this.depA, this.depB, aContextualValue);
    }
}