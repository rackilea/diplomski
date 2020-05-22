public static boolean isOnly916(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        // If value is invalid abort and return 'false'
        if (arr[i] != 9 && arr[i] != 6 && arr[i] != 1 ) {
            return false;
        }
    }

    // Checked all values, non was invalid
    return true;
}