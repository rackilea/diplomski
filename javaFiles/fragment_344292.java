int sum=IntStream.of(A).reduce(0, (a,b)->{
    int c=a+b;
    if(a>0? b>0 && c<0: b<0&& c>0)
        throw new ArithmeticException("overflow");
    return c;
});