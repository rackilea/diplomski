public class Outer
{
    private class Inner
    {
        // There's an implicit reference to an instance of Outer in here.
        // For example:
        // Outer outer = Outer.this;
    }

    private static class Nested
    {
        // There's no implicit reference to an instance of Outer here.
    }
}