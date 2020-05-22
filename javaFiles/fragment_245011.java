int length = m.length - 1;

   for (int row = 0; row <= length; ++row)
   {   
     m[row][length - row] = row;
     System.out.print(m[row][row]);
   }