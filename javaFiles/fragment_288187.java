private static int cumulative_sum(int num) {
    int count = 0;

    for (int k = 1; k <= num; k++) {
        int number = k;
        while(number > 0) {
            count+=number % 10;
            number/=10;
        }
    }
    return count;
}