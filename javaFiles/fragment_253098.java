abstract class AbstractFoo<SELF must be own type> {
    public abstract int compareTo(SELF o);
}

class C1 extends AbstractFoo<C1> {
    @Override
    public int compareTo(C1 o) {
        // ...
    }
}

class SubC1 extends C1 {
    @Override
    public int compareTo(/* should it take C1 or SubC1? */) {
        // ...
    }
}