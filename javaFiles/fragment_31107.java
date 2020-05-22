public static int[] generatePrizes(int size, int prizeMoney) {
     int[] prizes = new int[size + 1];
     int remainder = prizemoney;
     int lottery = prizeMoney ;
     for (int j = size; j > 3; j--) {
       prizes[j] = lottery ;
       remainder=  remainder - prizes[j];
       lottery = (int)Math.round(remainder* .75);
     }
     for (int k = 3; k >= 0; k--) {
         prizes[k] = remainder;
         remainder = 0;
     }
   return prizes;
 }