public static void moveLastup(String[] arr, int pos) {
    String last = arr[arr.length-1];

    // Copy sub-array starting at pos to pos+1
    System.arraycopy(arr, pos, arr, pos + 1, arr.length - pos - 1);

    arr[pos] = last;
}