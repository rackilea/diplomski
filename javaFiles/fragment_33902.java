public static int getHighestInRow (int[][] x, int rowCount, int colCount)
     {
         int highestInRow = 0;

         for (int rowIndex = 0; rowIndex < rowCount; rowIndex++)
         {
             highestInRow = x[rowIndex][0];
           for (int colIndex = 0; colIndex < colCount; colIndex++)
           {

           if (x[rowIndex][colIndex]>highestInRow)
                 highestInRow=x[rowIndex][colIndex];
           }
         System.out.println(highestInRow + " is the highest number in row " + (rowIndex+1) + ".");
         highestInRow = 0;
         }
         return highestInRow;
     }

    /* method getLowestInRow
       takes a 2d int array as input 
       returns the lowest number
       of all of the elements 
       in each individual row of
       the array as (int) outputs 
     */  

    //unfinished
    public static int getLowestInRow (int[][] x, int rowCount, int colCount)
    {
         int lowestInRow = 0;

         for (int rowIndex = 0; rowIndex < rowCount; rowIndex++)
         {
             lowestInRow = x[rowIndex][0];  
           for (int colIndex = 0; colIndex < colCount; colIndex++)
           {

           if (x[rowIndex][colIndex]<lowestInRow)
                 lowestInRow=x[rowIndex][colIndex];
           }
         System.out.println(lowestInRow + " is the lowest number in row " + (rowIndex+1) + ".");       
         lowestInRow = 0;
         }
        return lowestInRow;

    }