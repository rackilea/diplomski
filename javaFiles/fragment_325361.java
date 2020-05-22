interface A
{
    int CONSTANT1 = 6;
}

interface B
{
    int CONSTANT1 = 7;
}

public class Test implements A, B
{
    public static void main(String[] args)
    {
        System.out.println(CONSTANT1);
    }
}