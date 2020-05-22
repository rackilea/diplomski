int[][] int_table = new int[3][4];
for(int j = 0; j < 3; j++)
{  
   for(int i = 0; i < 4; i++)
   {
      int_table[j][i] = sum[j * 4 + i];
   }
}