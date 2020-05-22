public static int fibonacciR(int n)  {
    if(n == 0){
        //You removed the statement here!
        return 0;
    } else if(n == 1){
        return 1;
    }
    else{
        return fibonacciR(n - 1) + fibonacciR(n - 2);
    }
}