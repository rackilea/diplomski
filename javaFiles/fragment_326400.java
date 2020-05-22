static int maxOdd(int[] nums) {
    int max = 0;
    for (int v : nums) {
        if (v % 2 == 1) {
            max = Integer.max(max, v);
        }
    }
    return max;
}