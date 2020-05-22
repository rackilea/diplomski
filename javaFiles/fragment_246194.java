public static void patterPrinters(int n) {
    int i,j,k;
    for( i=0;i<n;i++)
    {
      for(k=0;k<((n-1)-i);k++)
      {
        System.out.print(" ");
      }
      System.out.print("*");
      for(j=0;j<(i*2);j++)
      {
        System.out.print("#")
      }
      System.out.print("*\n");
    }
}