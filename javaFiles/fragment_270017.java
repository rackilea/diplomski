import java.util.*;

public class Murray_A03Q3{
   public static void main (String [] args){

      int num = 1;
      int[] nums = new int[10];  

      List<Integer> list = new ArrayList<Integer>();

      Scanner scan = new Scanner(System.in);

      while(num != 0){
         System.out.print("Enter a value to plot: ");
         num = scan.nextInt();
         System.out.println();
         if(num > 0 && num <= 10)
            list.add(num);
         if(num > 10 || num < 0)
                System.out.println("Please enter a number 1-10");
      }

      for (int a = 0; a < list.size(); a++){
         nums[a] = Collections.frequency(list, a);
      }

      for (int count = 0; count < 10; count++){
         System.out.print((count+1) + "\t|");

         for(int h = 0; h < nums[count]; h++)
            System.out.print("#");

         System.out.println();
      }
   } // end of main
} // end of class Murray