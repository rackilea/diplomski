class Base<T> {
    protected T a;

    Base(T a) {
        this.a = a;
    }
}

class Daugher<L, R> extends Base<Pair<L, R>> {
    Daugher (Pair<L, R> a) {
        super (a);
    }
}