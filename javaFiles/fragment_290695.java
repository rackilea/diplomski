public static void shiftLeft(int shiftBy, int arr[]) {
    for (int j = 0; j < shiftBy; j++) {
        int a = arr[0];                         // storing the first index
        int i;
        for (i = 0; i < arr.length - 1; i++) {  // shifting the array left
            arr[i] = arr[i + 1];
        }
        arr[i] = a;                             // placing first index at the end
    }
}