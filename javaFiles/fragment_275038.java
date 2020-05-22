public class Demorun
{
    static int x = 20;

    public static void change()
    {
        x = 10;
        System.out.println("inside x: " + x);
    }

    public static void main(String[] args)
    {
        change();
        System.out.println("outside x: " + x);
    }
}