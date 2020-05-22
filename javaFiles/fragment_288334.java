import java.util.Scanner;
public class ProcessNumbers
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter an integer between 6 and 12, inclusive: ");
        int num = in.nextInt();
        System.out.print(num);
        System.out.println();
        boolean result = shouldProcess(num);
        processInput(result, num); // passing the result and num
    }

    public static boolean shouldProcess(int n) 
    {
        if (n>=6 && n<12)
        {
            return true;
        }
        else
        {
            return false;
        } 
    }

    public static void processInput(boolean result2, int num) // added int num argument
    {
        if (result2 == true)
        {
            //int sum = findSum(num);

            //public static void findSum(int num) // not allowed
            //{
                int sum = 0; // missed the semi-colon
                for (int i = 1; i <=num; i++)
                {
                      sum +=i;
                }
                System.out.println(sum); // missed the semi-colon
            //}
        }
        else 
        {
            System.out.println("Number is outside of acceptable range");
        }
    }  
}