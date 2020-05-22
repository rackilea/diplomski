public class Foo extends Bar ... {
     public Foo (Integer i, Double d, boolean b) {
        super(b ? i : d);
        ...
     }
}