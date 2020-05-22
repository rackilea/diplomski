public String fibo(int x){
    BigInteger[] arr = new BigInteger[x+1];
    arr[0]=BigInteger.ZERO;
    arr[1]=BigInteger.ONE;
    for (int i=2; i<=x; i++){
        arr[i]=arr[i-2].add(arr[i-1]);
    }
    return arr[x].toString();u
}