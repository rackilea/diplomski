class Outer {
    class Inner extends InnerBase<Outer> {
        ... little code
    }
}

class InnerBase<T> {
    protected int eger;
    ... most code
}