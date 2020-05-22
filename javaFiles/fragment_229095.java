public class Foo extends BaseClass<Foo> {
    private Gamma g;

    @Override
    public Foo setBeta(Beta b) {
        super.setBeta(b);
        doSomethingElse();
        return this;
    }

    private void doSomethingElse() { }

    public Gamma getGamma() {
        return g;
    }

    public Foo setGamma(Gamma g) {
        this.g = g;
        return this;
    }
}