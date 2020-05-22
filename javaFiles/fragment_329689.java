public class Main
{
    public static void main(String[] args)
    {
      int  iteration = 1;
      while(iteration<=10)
       {
           int count= 1;
           while(count<=10)
           {
               System.out.print(count + " ");
               count++;
           }
           System.out.print("\n");
           iteration++;
       }
    }
}