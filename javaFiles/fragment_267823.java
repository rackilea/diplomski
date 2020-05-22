public class Supplier<T>{
    //You might decide you need an actual constructor that does something
    public Supplier(){}

    public T supplyItem(){
        return new T();
    }
}