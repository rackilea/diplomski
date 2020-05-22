public static long NormalCase(int times,int[] result) {
        long firstTime=System.nanoTime();
        int computation= 0 ;
        for(int i= 0; i < times; i++ ) {
            int a= i + 1 ;
            int b= 2 ;
            a= a / b ;
            computation+= a ;
        }
        result[0]= computation ;
        return System.nanoTime()-firstTime;
    }