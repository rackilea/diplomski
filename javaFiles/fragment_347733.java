public static void main(String[] args) {
    int[] rateFrequency = { 0, 1, 2, 2, 2, 3, 3 };

    int maxNum = 0;
    for (int i = 0; i < rateFrequency.length; i++) {
        maxNum = Math.max(maxNum, rateFrequency[i]);
    }

    for (int num = 0; num <= maxNum; num++) {
        System.out.print(num + ": ");

        for (int i = 0; i < rateFrequency.length; i++) {
            if (rateFrequency[i] == num) {
                System.out.print(" * ");
            }
        }
        System.out.println();
    }
}