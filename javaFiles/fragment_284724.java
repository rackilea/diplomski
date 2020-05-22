public class B<S,T extends A<S>> {
    private T t;

    public S getTsSomething(){
        return t.f1();
    }
}