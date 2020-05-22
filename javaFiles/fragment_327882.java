public abstract class AbstractClass<T> {

    private Class<T> clazz;

    public AbstractClass(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void doFoo() {
        if (clazz instanceof SomeInterface){
            // do stuff
        }
    }
}