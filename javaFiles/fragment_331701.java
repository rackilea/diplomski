private static int counter(int A[])
{   
     int sum;
     int e = A.length;
     int count = 0;
     for (int i=0; i<e; i++)
     {
         for (int j=i+1; j<e; j++)
         {
             sum=A[i]+A[j];
             count += binarySearch(A,sum, j);

         }  
     }
     return count;
}