public class Test
{
    public static void main(String[] args)
    {
        xnor(false, false);
        xnor(false, true);
        xnor(true, false);
        xnor(true, true);
    }

    private static void xnor(boolean a, boolean b)
    {
        System.out.printf("xnor(%b, %b) = %b\n", a, b, a == b);
    }
}