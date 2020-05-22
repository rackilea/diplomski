static int[] sum(int[] A, int[] B)
{
  int index = SIZE -1; 
  int[] newBI = new int[SIZE];
  int carry = 0;
  while(index >=0)
  {   
      int sum = A[index] + B[index] + carry;
      if(sum >= 10) {
          carry = sum/10;
          sum = sum %10; 
      }
      else
      {
        // important to clear the carry
        carry = 0;
      }
      newBI[index] = sum; 
      index--; 
  }
  if(carry == 1)
  {
    throw new ArithmeticException();
  }
  return newBI; 
}