public final class Foo
{
    public static void yuck()
    {
        System.out.println("Yuck!");
    }

    public static void main(final String... args)
    {
        final Foo foo = null;
        foo.yuck(); // compiles, and does the job
    }
}