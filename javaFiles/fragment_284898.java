public class TestLiveness
{
    public static void test1()
    {
        System.out.println(new Square(4).square());
        count();
    }

    public static void test2()
    {
        Square t = new Square(4);
        System.out.println(t.square());
        count();
    }

    private static void count()
    {
        for(int i=0; i<1000000; i++)
            System.out.println(i);
    }

    static class Square
    {
        private int val;

        Square(int val)
        {
            this.val = val;
        }

        int square()
        {
            return val * val;
        }
    }
}