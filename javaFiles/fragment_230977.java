static void P6(int n) {
   for (int i = 1; i <= n/2; i++)
     for ( int j = 1; j <= n/4; j++)
       for (int k = 1; k <= n/8; k++)
         Procedure();
}