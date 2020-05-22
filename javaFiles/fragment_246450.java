public abstract class A<T>{
    private T id;
    public void setId(T id){
        this.id = id;
    }
}
public class B extends A<Long>{
}
public class C extends A<String>{
}