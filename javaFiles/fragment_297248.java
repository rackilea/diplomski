// Complete the maximumToys function below.
static int maximumToys(int[] prices, int k) {
    Arrays.sort(prices);
    int sum = 0;
    int index = 0;
    for(int i = 0; i < prices.length; i++) {
        sum+=prices[i];
        index = i;
        if(sum > k) {
            break;
        }
    }

    return index;

}