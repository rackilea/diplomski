int a[][]=new int[5][];

for(int i=0;i<5;i++)
{
  a[i]=new int[i+1];
  for(int j=0;j<=i;j++)
  {
    a[i][j]=j+1;
    System.out.print(a[i][j]);
  }
  System.out.println("");
}