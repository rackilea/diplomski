public static int sumArrayof(int[] data) {
    int k;
    int sum = 0;   
    for (k=0; k<data.length; k++) {
        sum = sum + data[k];
    }
    return sum;
}