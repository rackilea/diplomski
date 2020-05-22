public class Bar extends BaseClass<Bar> {
    private Omega o;

    @Override
    public Bar setAlpha(Alpha a) {
        super.setAlpha(a);
        doSomethingElse();
        return this;
    }

    private void doSomethingElse() { }

    public Omega getOmega() {
        return o;
    }

    public Bar setOmega(Omega o) {
        this.o = o;
        return this;
    }
}