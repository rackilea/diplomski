public static void main(String[] args) {
    int arr1[] = { 2, 4, 5, 7, 9, 10 };
    int arr2[] = { 1, 2, 5, 6, 8 };

    int min = Math.min(arr1.length, arr2.length); //We can never have more duplicates than the number of elements in the smallest array
    int counter = 0;
    int combined[] = new int[min];

    for (int s = 0; s < arr1.length; s++) {
        for (int x = 0; x < arr2.length; x++) {
            if (arr1[s] == arr2[x]) {
                combined[counter] = arr1[s];
                counter++;
                break; //We have found a duplicate, exit inner for loop and check next digit in outer loop
            }
        }
    }
    int[] result = Arrays.copyOf(combined, counter); //This makes a copy of the array but only with the number of elements that are used
    for (int i = 0; i < result.length; i++) {
        System.out.print(result[i] + " ");
    }
}