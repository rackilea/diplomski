public class AClass {
    private int privateInteger;
    public AClass() {
        privateInteger = 5;
    }
    // First way 
    public void accessFromLocalInstance() {
        AClass localInstanceOfClass = new AClass()
        int valueOfLocalInstance = localInstanceOfClass.privateInteger;
    }
    // Second way
    public void accessFromInstance(AClass instance) {
        int valueOfInstance = instance.privateInteger;
    }
}