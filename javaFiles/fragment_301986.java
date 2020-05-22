int fib(int low, int high){
       // Initialize first three Fibonacci Numbers
       int n1 = 0, n2 = 1, n3 = 1;

       // Count fibonacci numbers in given range
       int result = 0;

       while (n1 <= high){
            if (n1 >= low)
               result++;
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }

        return result;
 }