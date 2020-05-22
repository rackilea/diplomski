public static int[] noSpaceElementDistinctness(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n;i++) {
        boolean exists = false;
        for (int j = 0; j < i; j++) {
            if (arr[i] == arr[j]) {
                exists = true;
                break;
            }
        }
        if (exists) {
            for (int j = i+1; j<n; j++)
                arr[j-1] = arr[j];
        n--;
        i--; //to iterate the next element, which is now at index i, not i+1.
        }
    }
    for (int i = n; i < arr.length; i++) arr[i] = Integer.MIN_VALUE; //indicates no value
    return arr;

}