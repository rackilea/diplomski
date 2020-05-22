interface SomeInterface <T> {
    void doing (T t);
}

public class A implements SomeInterface <A.B> {
    public void doing (A.B ab) {}
    class B {}
}