public static void main(String[] args) {
    int[][] samples = {
        {100, 20, 12, 15, 19},
        {45, 5, 100, 4, 12, 100, 6},
        {2, 3, 100, 4, 5, 60}
    };
    outputValues(samples);
}

private static void outputValues(int[][] samples) {
    int startIndicator = 100;
    int upperBound = 20;
    for (int[] sample : samples) {
    int startIndicator = 100;
    int upperBound = 20;
    for (int[] sample : samples) {
        System.out.println("---------------");
        boolean startIndicatorFound = false;
        boolean startValueFound = false;
        boolean endValueFound = false;
        for (int i = 0; i < sample.length; i++) {
            int value = sample[i];
            System.out.printf("%d", value);
            if (endValueFound) {
                // do nothing
            } else if (i == (sample.length - 1)
                    || startValueFound && sample[i + 1] > upperBound) {
                endValueFound = true;
                System.out.print(",End Value");
            } else if (startIndicatorFound && !startValueFound
                    && value <= upperBound) {
                startValueFound = true;
                System.out.print(",Start Value");
            } else if (!startIndicatorFound && value == startIndicator) {
                startIndicatorFound = true;
            }
            System.out.println("");
        }
    }
}