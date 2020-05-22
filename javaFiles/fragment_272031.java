public class OtherClass {

    public void otherMethod() {
        Example example = new Example();
        synchronized (example) {
            ...
        }
    }
}