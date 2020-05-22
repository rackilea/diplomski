public class Test
{
    public static void main(String[] args)
    {
        Number n = new Integer(10);
        compare(n);
    }

    public static void compare(Number n)
    {
        int i=10;
        System.out.println(n == 10);
    }
}