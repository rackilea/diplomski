public class MyClass {
    private boolean someSetting;

    public MyClass() {
        someSetting = getSetting();
    }

    private boolean getSetting() {
        ...
    }

    public void main() {
        // By the time this is called we can guarantee that someSetting has been initialized correctly
        // Do main stuff...
    }
}