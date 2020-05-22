public static int modifiedFibonacci(int n)
{
   if(n > 1){
       int f1 = 0;
       int f2 = 0;
       int result = 0;
       for (int i = 2; i <= n; i++)
       {
          result = f1 + f2 + 2;
          f2 = f1;
          f1 = result;
       }
       return ++result;
   }
   return 1;
}