int[] arr1 = { 1, 11, 5, 9, 4, 3, 4, 8 };
int[] arr2 = { 1, 7, 5, 3, 4, 8 };

Arrays.sort(arr1);
Arrays.sort(arr2);

for (int i : arr1) {
    boolean contains = false;
    for (int j : arr2) {
        if (i == j) {
            contains = true;
            break;
        }
    }
    if (!contains)
        System.out.println("Arr2 doesn't contain number: " + i);
}