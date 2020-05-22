public void printGrid()
{
   for(int i = 0; i < 20; i++)
   {
      for(int j = 0; j < 20; j++)
      {
         System.out.printf("%5d ", a[i][j]);
      }
      System.out.println();
   }
}