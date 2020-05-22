for (long n=2;n<18;n+=2) {
        long res = 1;
        for (long l=n+2;l<=2*n;l++)
           res *= l;
        for (long l=2;l<=n;l++)
           res=res/l;
        System.out.println(res);
    }