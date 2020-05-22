int n = number of verticles;
int[][] D = RunDijkstraOrWarshall()
// D[a,b] = length of shortest path from a to b
int[] Vm = new int[n];
for(int i=0; i<n i++)
{
   Vm[i] = 0
   for(int j=0; j<n; j++) 
   {
     if (Vm[i] < D[i,j]) Vm[i] = D[i,j];
   }  
}

minVm = int.Max;
for(int i=0; i<n ;i++)
{
  if (minVm < Vm[i]) minVm = Vm[i];
}

for(int i=0; i<n ;i++)
{
  if (Vm[i] == minVm)
  {
     // graph center contans i
  }