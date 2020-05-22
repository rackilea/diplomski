public class Sorting {

    public static <T extends Comparable<T>> void selectionSort(List<T> numbers) {

        int indexSmallest = 0;
        for (int i = 0; i < numbers.size(); i++) {
            // Find index of smallest remaining element
            indexSmallest = i;
            for (int j = i + 1; j < numbers.size(); j++) {
                // use compareTo
                if (numbers.get(j).compareTo(numbers.get(indexSmallest)) < 0) {
                    indexSmallest = j;
                }
            }

            // EDIT: your swapping code was wrong
            // Swap numbers[i] and numbers[indexSmallest]
            T temp = numbers.get(i);
            numbers.set(i, numbers.get(indexSmallest));
            numbers.set(indexSmallest, temp);
        }
    }
}