private static int[] generateRandomArray(int size, int randomMax) {
    int[] array = new int[size];
    Random randomGenerator = new Random();
    for (int i = 0; i < size; i++) {
        array[i] = randomGenerator.nextInt(randomMax);
    }
    return array;
}

public static void main(String[] args) {
    int MethodChoice = Integer.parseInt(JOptionPane.showInputDialog("What method would you like to use to sort the random numbers" + "\n" + "1 - Selection Sort" + "\n" + "2 - Bubble Sort" + "\n" + "3 - Insertion Sort" + "\n" + "4 - Quick Sort"));
    int iTotalCount = Integer.parseInt(JOptionPane.showInputDialog("What is the total number of integers?"));
    int SortOrder = Integer.parseInt(JOptionPane.showInputDialog("1 - Ascending, " + "2 - Descending"));

    int[] array = generateRandomArray(iTotalCount, 1001);

    System.out.println("Randomly Generated number list: ");
    for (int i : array) {
        System.out.print(i + " ");
    }
    System.out.println("\n---------------------------------");

    if (MethodChoice == 1) {
        if (SortOrder == 2) {
            selectionSortReverse(array);
            System.out.println("After sorting using the Selection Sort, " + "Using Descending Order" + "the array is: ");
        } else if (SortOrder == 1) {
            selectionSort(array);
            System.out.println("After sorting using the Selection Sort," + " the array is:");
        }
    } else if (MethodChoice == 2) {
        // bubble-sort
    }

    for (int i : array) {
        System.out.print(i + " ");
    }
}