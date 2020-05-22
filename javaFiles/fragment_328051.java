class Main
{
   // create a variable to hold the array
   // initialize the array with the values shown

   static int[][] mat =
         { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 0 }, { 6, 7, 1, 2, 5 }, { 6, 7, 8, 9, 0 }, { 5, 4, 3, 2, 1 } };

   public static void main(String[] args)
   {
      System.out.println("The sum of 1, 1 is " + sumAround(2, 3, 5, 5));
   }


   public static int sumAround(int row, int col, int max_row, int max_col)
   {

      int dx[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
      int dy[] = { -1, 0, 1, 1, 1, 0, -1, -1 };

      int sum = 0;

      for (int i = 0; i < 8; i++)
      {
         if (row + dx[i] >= 0 && row + dx[i] < max_row && col + dy[i] >= 0 && col + dy[i] < max_col)
            sum += mat[row + dx[i]][col + dy[i]];

      }

      return sum;
   }
}