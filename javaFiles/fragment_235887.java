String [][] anArray = new String [N][M];

for ( i = 0; i < N; i ++)
  for ( j = 0; j < M; j ++)
  {
    if(i == 0 || i == N-1 || j == 0 || j == M-1) anArray[i][j] = "*"; // Put * on the frame
    else anArray[i][j] = " "; // Put spaces inside

   }

 for ( i = 0; i < N; i ++)  //Print the picture
   for ( j = 0; j < M; j ++)
   {
       printf("%s",anArray[i][j]);
       if(j == M-1) printf("\n");
   }