public static int findSmallest(int[] arr) {
    int smallest = Integer.MAX_VALUE;
    for(int i=0; i<arr.length; i++) {
        if(arr[i] > 0 && arr[i]<smallest) {
            smallest = arr[i];
        }
    }
    return smallest;
}