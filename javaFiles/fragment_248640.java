public class Test<T> {
    private T myInstance;

    public T getInstance() {
        return myInstance;
    }

    public void setInstance(T argType) {
        myInstance = argType;
    }
}