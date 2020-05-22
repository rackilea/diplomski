public static int binarySearch(String[] array, String word, long resultsArray[]) {
    int start = 0;
    int end = array.length - 1;
    int midPt;
    int pos = -1;
    int comparisons2 = 0;

    //Arrays.sort(array);

    long start2 = System.nanoTime();
    while (start <= end) {
        midPt = (start + end) / 2;
        int comparisonResult = array[midPt].compareToIgnoreCase(word);
        comparisons2++;
        if (comparisonResult == 0) {
            pos = midPt;
            break;
        } else if (comparisonResult < 0) {
            start = midPt + 1;
        } else { // comparisonResult > 0
            end = midPt - 1;
        }
    }
    long stop2 = System.nanoTime();
    long total2 = stop2 - start2;

    resultsArray[0] = total2;
    resultsArray[1] = (long) array.length;
    resultsArray[2] = (long) comparisons2;
    return pos;
}