int[] array = new int[5];
Arrays.fill(array, 1);
// array now contains [1, 1, 1, 1, 1]           

// Only fill a specified range:
int[] array2 = new int[10];
Arrays.fill(array2, 3, 7, 2);
// array2 now contains [0, 0, 0, 2, 2, 2, 2, 0, 0, 0]