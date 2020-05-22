public class Sealed
{
    private Sealed() { }

    public final static class Foo extends Sealed {
       public Foo() { }
    } 
}