public interface I1
{
    String getGreeting();
}

public interface I2
{
    default String getGreeting() {
        return "Good afternoon!";
    }
}

public class C1 implements I1, I2 // won't compile
{
    public static void main(String[] args)
    {
        System.out.println(new C1().getGreeting());
    }
}