public class HelloWorld{

 public static void main(String []args){
    for (int i = 1; i <= 10; i++)
    {
        if (!IsPrime(i)) continue;

        for (int j = 1; j <= 5; j++)
        {
            int value = i * j;
            System.out.println(i + " multiplied by " + j + " = " + value);
        }
    }
 }

public static boolean IsPrime(int candidate)
{
    if ((candidate & 1) == 0)
    {
        return candidate == 2;
    }

    for (int i = 3; (i * i) <= candidate; i += 2)
    {
        if (candidate % i == 0)
        {
            return false;
        }
    }
    return candidate != 1;
}