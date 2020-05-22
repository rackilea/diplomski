public class Foo extends Bar ... {
     public Foo (Integer i) {
        super(i);
        ...
     }
     public Foo (Double d) {
        super(d);
        ...
     }

     public static Foo createFoo(Integer i, Double d, boolean b) {
        return b ? new Foo(i) : new Foo(d);
     }
}