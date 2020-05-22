import java.util.Scanner;

public class Demo {
public static void main(String[] args)
{
    Scanner x=new Scanner(System.in);
    int n=0;int g=0; int term=0;int temp=0;
    int sum=0; int factor=1;
    System.out.print("Input N:");

    n=x.nextInt();
    g=n;
    int number = 0;
    if (n<=0)
    {
        System.out.println("Please enter a positive integer");
        System.exit(0);
    }

    if (n>0)
    {
        System.out.print("The factors are:");

        while (factor<n)
        {
            if (n%factor==0)
            {
                System.out.println(factor+",");
                number+=factor;
            }
            factor++;
        }
    }
    System.out.println("Sum = "+number);
}
}