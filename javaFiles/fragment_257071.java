int a[][] = new int[4][4];
int n,m;
n=4;
m=4;
for(int i=0;i<m;i++){
 for(int j=0;j<n;j++){
  if(i==0 || j==0 || i==m-1 || j==n-1){
   //a[i][j] = 0; 
   a[i][j] = 1;
   }
   System.out.print(a[i][j]+" ");
 }
  System.out.println();
}