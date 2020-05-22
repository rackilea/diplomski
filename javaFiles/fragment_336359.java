import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        int testcases=sc.nextInt();

        while(testcases-- >0)
        {
            int n=sc.nextInt();

            long array[]=new long[n+1]; //Take long array to avoid overflow

            for(int i=1;i<=n;i++)
            {
                for(int j=i;j<=n;j+=i)
                {
                    array[j]++;          //This will store that which elements get increased
                                         //from zero how many times
                }
            }

            //Now we can do summation of all elements of array but we need to do prefix sum here

            long sum=0;
            for(int i=1;i<=n;i++)
            {  
                array[i]+=array[i-1];
                sum+=array[i];
            }

            System.out.println(sum);
        }
    }
}