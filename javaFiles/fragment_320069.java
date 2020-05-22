private static void doPermute(int[] arr, int[] res, int currIndex, int level, int r) {
    if(level == r){
        printArray(res);
        return;
    }
    if(currIndex<arr.length){
        res[level] = arr[currIndex];
        doPermute(arr, res, currIndex+1, level+1, r);
        doPermute(arr, res, currIndex+1, level, r);
    }
}