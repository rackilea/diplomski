public class MyObject {
    private ThirdPartyObject dependency;

    public MyObject() {
        // initialize the dependency
    }

    public boolean getValue() {
        return this.dependency.getValue();
    }

    public void setValue(boolean value) {
        this.dependency.setValue(value);
    }
}