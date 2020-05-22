public int ascending(int[] a, int key, int lo, int hi) {
    int mid = lo+(hi-lo)/2;
    while(lo<=hi) {
        if (key<a[mid]) hi = mid-1;
        else if (key>a[mid]) {
            lo=mid+1;
            System.out.println(lo);
        }
        else return mid;
    }
    return -1;
}