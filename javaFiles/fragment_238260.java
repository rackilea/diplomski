public static int[] fillArray(int count) {
    int[] arr = new int[count];
    int n = 0;
    for (int i = 1; n < arr.length; i++) {
        if (checkPrime(i)) {
            arr[n] = i;
            n++;
        }
    }
    return arr;
}