static long countBis(int n) {
        long fn, f1, f2, f3, f4, f5, f6;
        int i;
        f1=f2=f3=f4=f5=f6=fn = 1;
        for ( i = 2; i <= n; i++ ) {
            f6 = f5;      
            f5 = f4;      
            f4 = f3;
            f3 = f2;
            f2 = f1;
            f1 = fn;
            fn = f6 + f5 + f4 + f3 + f2 + f1;
        }
        return fn;
    }