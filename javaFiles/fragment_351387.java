public static int MyhashFUNC(String str,int A){
    int X=0;
    int sum = hash_func(str);
    if(sum<A)
        return sum;
    else{
        X = X+sum%10;
        sum /= 10;
        return(MyhashFUNC(str, A));  // Call again MyhashFUNC with same parameters
    }
}