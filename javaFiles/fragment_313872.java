public static void main(String[]args){
    int divisors = 0; //skip the = 0
    for(long x=1;divisors<=501;++x){ // ++x instead of x++
        divisors=0;
        long i=(x*x + x) >> 1; // see above, use the one you like more
        /*how many divisors*/
        if(i == 1) divisors = 1;
        else{ /*1 is the only number with just one natural divisor*/
            divisors = 2; // the 1 and itself
            for(int n = 2; n*n <= i; ++n){
                if(n*n == i) ++divisors;
                else if(i%n == 0) divisors += 2;
            }
        }
        System.out.println(i+": " + divisors);
    }
}