public class ppLoop{
   public static void main(String[] args)
   {
      {

         for(int i = 1; i < 2; i++) // One iteration of outer loop
         {
            System.out.print(i + ". "); // print row number

            // you can use the same variable for each inner loop    
            for (int j = 4; j < 11; j++) // loop for row 1   
            {
               System.out.print(j + " ");
            } 

            System.out.println( );
            System.out.print((i + 1) + ". ");
            for (int j = 6; j > 0; j--) // loop for row 2
            {
               System.out.print(j + " ");
            }

            System.out.println();
            System.out.print((i + 2) + ". ");
            for (int j = 2; j < 17; j = j + 2) // loop for row 3
            {
               System.out.print(j + " ");
            }
         } 
      }
   }
}