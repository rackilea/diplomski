int[] Example1 = {85, 80, 85};
    int[] Example2 = {75, 91, 52};
    int[] Example3 = {92, 89, 78};
    int[][] examples = {Example1, Example2, Example3}; // new array

    for (int i = 0; i < examples[0].length; i++) {
        double rowAverage = 0;
        for (int[] arr : examples) {
                rowAverage += arr[i];
        }
        System.out.println("Average of row " + (i + 1) + ": " + rowAverage / examples.length);
    }