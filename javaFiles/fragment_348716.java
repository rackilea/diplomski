import java.util.*; 

public class test
{
  public static int[] addToArray(int[] bag, int value, int i)
  {
    int j; 
    for(j = i; j <= bag.length - 1; j++)
    {
        bag[j] = value;
        if(bag[j] == 0)
        {
            for(; j <= bag.length - 1; j++)
            bag[j] = 0;
            return bag;
        }

      }
      return bag;
   }

   public static void main(String[] args) 
   {
     Scanner scan = new Scanner(System.in);
     int[] bag = new int[5];
     int i, value;
     i = 0;
     System.out.println("Enter the values : ");
     do
     {
         value = scan.nextInt();
         addToArray(bag, value, i);
         i++;               
     }
     while(value != 0);

     System.out.println(Arrays.toString(bag)); 
   }
}