public class Test
{
    public static void main(String args[]) throws Exception
    {
        Rectangle a = new Rectangle(5, 5, 30, 30);
        Rectangle b = new Rectangle(10, 10, 50, 50);
        a = a.union(b);
        System.out.println(a);
        System.out.println(b);
    }
}