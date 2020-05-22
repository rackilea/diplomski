public class Outer
{
    private Inner inner = new Inner();

    // Inner class, with implicit reference to "containing" Outer
    public class Inner
    {
    }
}