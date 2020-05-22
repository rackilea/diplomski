public static void quickSort(int[] array) 
{
    doQuickSort(array, 0, random1.length - 1);
    System.out.println("\nComparisons: " + compare); 
    System.out.println("Swaps: " + swap);
}