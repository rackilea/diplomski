public static int fib2(int n){
    int a = 0;
    int b =1;
    while(n-- >0){
        int old_a;
        old_a = a;
        a=b;
        b=old_a+b;
    }
    return a;
}