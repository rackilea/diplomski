static long mod = 100000;
public static long Solving(int n) {
    int five = 0;
    for (int power5 = 5, count ; 0 < (count = n / power5) ; power5 *= 5){ 
        five += count; 
    }

    // Number of pair (2,5) is the min number between 2 and 5
    int removeFactorTwo = five;
    int removeFactorFive = five;
    long result = 1;
    for(int i = 2; i <= n; i++){
        int st = i;
        while(st % 2 == 0 && removeFactorTwo > 0){
            st /= 2;
            removeFactorTwo--;
        }
        while(st % 5 == 0 && removeFactorFive > 0){
            st /= 5;
            removeFactorFive--;
        }
        result *= st;
        // This will make sure result always <= 10^5
        result %= mod;
    }
    return result;
}