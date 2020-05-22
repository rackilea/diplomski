sum = 0;
   sum += square[0][0];
   sum += square[1][1];
   sum += square[2][2];
   sum += square[3][3];
   if (sum != n)
      return false;

   sum = 0;
   sum += square[0][3];
   sum += square[1][2];
   sum += square[2][1];
   sum += square[3][0];
   if (sum != n)
      return false;