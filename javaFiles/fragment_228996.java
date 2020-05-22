public class FooWrapper {
    public final Foo foo; //constructor omitted

    public boolean equals(Object other) {
         //type check omitted here too
         return foo.A == other.foo.A;
    }

    //hashCode omitted, but you need that too
}