public <T> void selectionSort(ArrayList<T> array, Comparator<T> comparator) {

    // for i from 0 to array.size():
        // currentMinIndex = i
        // for j from i + 1 to array.size():
            if (comparator.compare(array.get(j), array.get(currentMinIndex))) < 0) {
                // currentMinIndex = j
            }

            // swap array at currentMinIndex with array at i
}