static boolean check_pal(long n){
    return reverse(n) == n;
 }

 static long reverse(long n)
    {
        long digit;
        digit=(long) (Math.log10(n)+1);
        long a=0,b=0,i,j,p;
        long sum=0;
        for(i=1,j=digit-1 ; i<=digit ; i++,j-- )
        {
            a=(long) get(n,i,digit);
            sum+=a*Math.pow(10,j);
        }
        return sum;
    }

 static long reverseAndAdd(long n){
     return n + reverse(n);
 }