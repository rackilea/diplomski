int sumDig(int n) // Function for finding and returning sum of digits of a number
{
   int a = 0;
   while(n>0)
   {
       a = a + n%10;
       n = n/10;
   }
   return a;
}