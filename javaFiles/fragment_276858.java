public abstract class AbstractFoobar<A extends AbstractFoobar<A>> {
    // ...
    abstract A newInstance(String arg);
}

public class Bar extends AbstractFoobar<Bar> {
    // ...
    Bar newInstance(String arg) { return new Bar(arg); }
}