public static int binarySearch(int[] arr, int num, int l,int r) {
    int mid = (l+r)/2;
    if(arr[mid] == num && (mid>0&& arr[mid-1]!=num) || mid==0) {            
        return mid;
    }       
    else if(arr[mid] > num || (mid > l && arr[mid] == num && arr[mid-1] == num)) {
        return binarySearch(arr, num, l, mid);
    }else {
        return binarySearch(arr, num, mid, r);
    }
}