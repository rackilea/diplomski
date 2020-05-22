public class DoesNotCompileEither
{
    static {
        foo = 3; // ERROR: what is foo?
    }
    private static final int foo;