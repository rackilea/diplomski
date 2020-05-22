public static void main(String[] args) {

    BigInteger sum = new BigInteger("2");
    boolean isPrime = true;
    for (int i=3; i<2000000; i++) {
    double aa = Math.sqrt((double)i);
        for (int j=2; j<=aa; j++){
            if (i % j == 0){ 
                isPrime = false;
                break;
            }
        }
        if(isPrime){
            sum = sum.add(BigInteger.valueOf(i));
        }
        isPrime = true;
    }
    System.out.println("Sum  = "+sum); 
}