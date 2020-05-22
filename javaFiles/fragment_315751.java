public static void printPowerOfTwoStars(int n){
    if(n <= 0){
        System.out.print("*");
    }
    else{
        printPowerOfTwoStars(n-1);
        printPowerOfTwoStars(n-1);
    }
}