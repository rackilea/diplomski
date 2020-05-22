private static int bsearch( int[] arr, int count, int key) {
    if (count==0) return -1;
    int lo = 0, hi = count - 1, mid = hi>>1;
    while(hi >= lo) {
          mid = (lo + hi) >> 1;
          if ( key < arr[mid] ) hi = mid-1;
          else if ( key > arr[mid] ) lo = mid+1;
          else return mid;
    }
    return ~lo;
}