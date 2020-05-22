import java.util.Scanner;

public class HelloWorld{

     public static void main(String []args){

            Scanner read = new Scanner(System.in);
            System.out.println("Enter values as much as you want (lower than 100000).\n To stop Enter \"0\" ");

            int Xth;

            do
            {
                Xth = read.nextInt();


                // Some coding here 
                if (Xth > 100000)
                {
                    System.out.println("Type a number lower than 100000");
                    continue;
                }
                int count = 0;
                for (int i = 1; i <= 1000000000; i++)
                {
                    if (!isPalindrome(i))
                        continue;

                    count++;
                    if (count == Xth)
                    {
                        System.out.println(Xth + "th palindromic number is " + i);
                        break;
                    }
                }
                if (count != Xth)
                    System.out.println("I can't compute that!");


            } while(Xth != 0);
     }

     private static StringBuilder sb = new StringBuilder();

     private static boolean isPalindrome(int i)
     {
        sb.setLength(0);
        sb.append(i);
        return  sb.toString().equals(sb.reverse().toString());
     }