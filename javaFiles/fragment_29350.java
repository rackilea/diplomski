public abstract class RootProcessor<T> {
    Class<T> clazz;

    protected RootProcessor<T>(Class<T> clazz) {
        this.clazz = clazz;
    }
}

public class FooProcessor extends RootProcessor<Foo> {
    public FooProcessor() {
        super(Foo.class);
    }
}