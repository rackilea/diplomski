public class Test
{
    public static void main(String args[])
    {
        new Test();
        System.gc();
    }

    @Override
    public void finalize() throws Throwable
    {
        super.finalize();
        this.finalize("allo");
    }

    public void finalize(String hi)
    {
        System.out.println(hi);
    }
}