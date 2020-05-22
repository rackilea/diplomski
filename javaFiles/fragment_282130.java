public class Foo<T> {

    private T t;

    public Foo(Class<T> cls) throws Exception {
        this.t = cls.newInstance();
    }

}