public static int timesOccur(int[] small, int big[]) {
        int sum = 0;
        for (int i = 0; i < big.length - small.length + 1; i++) {
            int j = 0;
            while (j < small.length && small[j] == big[i + j]) {
                j++;
            }
            if (j == small.length) {
                sum++;
            }
        }
        return sum;
    }