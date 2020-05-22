public interface X<T> {
    public void foo(T i);
}

public class Y implements X<Y> {
    public void foo(Y i){
        fooBar(foo);
    }
}