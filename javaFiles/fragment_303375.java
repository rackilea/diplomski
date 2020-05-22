public static void factorize(int n){
    int factorA = 0;
    int factorB = 0;

    if (n % 2 == 0){                                                 
        factorA = 2;
        factorB = n/2;
    }else{                                                           
        int halfLine = n/2;                                         
        int smallestFactorOdd = 3;