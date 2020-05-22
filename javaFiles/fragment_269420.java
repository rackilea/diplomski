if(K == N-1) {
    if(N < 2)
        return BigInteger.valueOf((long)Math.pow(N, N-2)).toString();

    // multiply N to itself N-2 times
    BigInteger val = BigInteger.ONE;

    int count = 0;

    while(count++ != N-2)
        val = val.multiply( BigInteger.valueOf( (long)N ) );

    return val.toString();
}