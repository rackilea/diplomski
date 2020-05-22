for (long n=2;n<18;n+=2) {
        double res = 1;
        for (long l=n+2;l<=2*n;l++) {
           res *= l;
           res /= (l-n);
        }
        System.out.println((long)res);
    }