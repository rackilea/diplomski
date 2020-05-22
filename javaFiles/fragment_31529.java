static int simpleArraySum(int n, int[] ar) {
    int sum = 0;
    for(int ar_i = 0; ar_i < n; ar_i++){
        sum = sum +ar[ar_i];      
    }
    return sum;
}