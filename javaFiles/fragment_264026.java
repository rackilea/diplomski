//diagonal from top left corner to bottom right corner
   sum = 0;
   for (int i = 0; i < square.length; i++)
   {
      sum += square[i][i];
   }
   if (sum != n)
      return false;

   sum = 0;
   // top right to bottom left diagonal
   for (int i = 0; i < square.length; i++)
   {
      sum += square[i][square.length - 1 - i];
   }
   if (sum != n)
      return false;