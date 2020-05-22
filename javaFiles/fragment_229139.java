public class Test
{
    public Test() {
        System.out.println("NO ARGS");
    }

    public Test(String s) {
        this();
        System.out.println("1 ARG");
    }

    public static void main(String args[])
    {
        Test t = new Test("s");
    }
}