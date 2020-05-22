public class MyClass <U>{
    public <T> MyClass(Set<T> data, Function<T,U> func) {...}
    public MyClass(Set<U> data){
        this(
          data,
          (item)->{return item;}
        );
    }
}