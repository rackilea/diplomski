public class Store<T> {
    private T value;

    public void set(T object){
        value = object;
    }

    public T get(){
        return value;
   }
}