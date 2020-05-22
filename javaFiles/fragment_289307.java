public final class AutoCloseableExample
{
    private static final class Foo
        implements AutoCloseable
    {
        @Override
        public void close()
            throws IOException
        {
            System.out.println("foo");
            throw new IOException();
        }
    }

    public static void main(final String... args)
    {
        try (
            final Foo foo = new Foo();
        ) {
            System.out.println("try block");
        } catch (IOException ignored) {
            System.out.println("exception!");
        } finally {
            System.out.println("finally block");
        }
    }
}