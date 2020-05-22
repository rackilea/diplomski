public static int getGCF(int num1, int num2) {
    int remainder = num1 % num2;

    if(remainder == 0) {
       return num2;
    } else {
        return getGCF(num2, remainder);
    }
}