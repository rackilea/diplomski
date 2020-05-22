public static void quickSort(int[] arr, int low, int high) {
    long startTime = System.currentTimeMillis();

    // Call the helper
    quickSortHelper(arr, low, high);

    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println(elapsedTime + " milliseconds");
}

private static void quickSortHelper(int[] arr, int low, int high) {
    // All code goes here, adjust calls
    // to 'quickSort', they should now call 'quickSortHelper'
}