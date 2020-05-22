public class Neon
{
private static int findDigitSum(int num) {
    return (num == 0) ? num : num % 10 + findDigitSum(num / 10);
}

public static void main(String [] args)
{
    int n,m,z=0;

    for(n=0; n<11; n++)
    {
      m=n;

      int x=m*m;

      z= findDigitSum(x);//It's much easier to use a separate method to calculate sum of digits 

      if(z==n)
      {
        System.out.println(n+" is a Neon no.");
      }
      else
      {
        System.out.println(n+" is not a Neon no.");
      }
    }
}
}