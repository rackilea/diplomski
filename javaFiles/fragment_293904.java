public static boolean theSame(int[] arr, int start, int end) {
    if(arr[start]==arr[end]) {
        if(start!=end) {
            start++;
            theSame(arr, start, end);  // here's your problem
            // return theSame(arr, start, end); might work better
        }
        else {
            return true;
        }
    }
    return false;
}