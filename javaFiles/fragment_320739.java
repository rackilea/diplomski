public class IdentityValueProvider<T> implements ValueProvider<T, T> {
    public T getObject(T object) {
        return object;
    }
    public void setValue(T object, T value) {
        //can't do anything to set object to a new value, ignore, or throw exception
    }
    //...
}