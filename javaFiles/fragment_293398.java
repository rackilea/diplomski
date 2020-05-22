public static int binarySearch(double[] arr, int low, int high, double inq){
    int mid = (low + high)/2;
    if(arr == null || low > high) return -1;

    if(arr[mid] == inq) return mid;

    if(arr[mid] < inq) { // inq is in the upper half
        return binarySearch(arr, mid+1, high, inq);
    }
    if(arr[mid] > inq) { // inq is in the lower half
        return binarySearch(arr, low, mid-1, inq);
    }
}