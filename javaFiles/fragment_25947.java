public class Main
{
    public static void main(String[] args)
    {
        final ExecContext<String>  stringCtx;
        final ExecContext<Integer> integerCtx;

        stringCtx  = new ExecContext<String>();
        integerCtx = new ExecContext<Integer>();
        exec(stringCtx, "Hello, World");
        exec(integerCtx, 42);
    }

    public static class ExecContext<T>
    {
        public void doSomething(final T e)
        {
            System.out.println(e);
        }
    }

    public static <T> void exec(final ExecContext<T> ctx,
                                final T              value)
    {
        ctx.doSomething(value);
    }
}