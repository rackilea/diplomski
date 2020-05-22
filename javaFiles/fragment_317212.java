public class NestedLoop2
    {
      public static void main(String[] args)
      {
        // The loop begins in row 3, because the first example is: 123
        // And the row will iterate till the 7, to print 5 rows
        for(int row = 3; row <= 7; row++)
        {
          // This loops always begins from 1 and
          // will iterate till the row, to increase the columns
          // Example: 1°: 123, 2°: 1234, etc
          for(int column = 1; column <= row; column++)
          {

            System.out.print(column);

          }
          System.out.println();
        }
      }
    }