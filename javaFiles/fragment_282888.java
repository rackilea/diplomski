public boolean allInRange(int[] arr) {
    for (int i = 0; i < arr.length; i ++) {
        if (!isInRange(arr[i])) return false;
    }
    return true;
}