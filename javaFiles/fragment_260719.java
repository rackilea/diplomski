int fact1(int n){
    int result;
    if(n==1)return 1;

    // Here's the difference: call the 'next' method
    result=fact2(n-1)*n;

    System.out.println("Recursion"+result);
    return result;
}