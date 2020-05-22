public static <E extends Comparable<E>> void quickSort(ArrayList<E> input, int low, int high) {
    if (low >= high)
        return;

    // generates the random pivot
    int pivotIndex = new Random().nextInt(high - low + 1) + low;

    E pivot = input.get(pivotIndex);

    // moves the pivot to the beginning of the list
    Collections.swap(input, pivotIndex, low);

    int i = low;
    int j = high;

    // if the values on the left side of the array are less than the
    // value of the pivot, first is incremented (first part of loop) until
    // a greater value is reached

    // if the values on the right side of the array are greater than the
    // value of the pivot, last is incremented until a lesser value is
    // reached

    while (i <= j) {
        while (input.get(i).compareTo(pivot) <= 0 && i < j) {
            i++;
        }
        while (input.get(j).compareTo(pivot) > 0 && j >= i) {
            j--;
        }

        // break here when two pointers meet since the pivot position has been found
        if (i >= j)
            break;

        // switches the two values reached through the while loops
        Collections.swap(input, i, j);
    }

    // moves the pivot to where j is
    Collections.swap(input, low, j);

    // calls the method recursively
    quickSort(input, low, j - 1);

    quickSort(input, j + 1, high);

}