public class C1 implements I1, I2 // this will compile, bacause we have overridden getGreeting()
{
    public static void main(String[] args)
    {
        System.out.println(new C1().getGreeting());
    }

    @Override public String getGreeting()
    {
        return "Good Evening!";
    }
}