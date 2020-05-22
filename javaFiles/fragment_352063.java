public class C<T extends Interface> {
    private final T foo;

    public C(T foo){
       this.foo = foo;
    }

    public void doSomethingElse() {
        foo.doSomething();
    }

    public static void main(String[] args) {
        C<?> c;
        if(isSomethingLoaded) {
            c = new C<>(new A());
        } else {
            c = new C<>(new B());
        }
        c.doSomethingElse();
    }
}