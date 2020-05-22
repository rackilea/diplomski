fact(n)
{
if(A[n]!=-1) return A[n];
A[0]=0;
A[1]=1;
for i=2 to n
  A[i]= addition of A[i],A[i-1];
return A[n]
}