public static double bubbleSortTimeTaken(int[] BubArray) {
    long startTime = System.nanoTime();
    bubbleSort(BubArray);
    long timeTaken = System.nanoTime() - startTime;
    return timeTaken;
    }
}