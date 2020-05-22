public static boolean isOnly916(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == 9 || arr[i] == 6 || arr[i] == 1 ) {
            return true;
        }
    }
    return false;
}