public static int rBsearch(int[] L, int low, int high, int k) {


    int mid = (low + high) / 2;

    if (low > high) {
        return -1;
    } else if (L[mid] == k) {
        return L[mid];
    } else if (L[mid] < k) {
        return rBsearch(L, mid + 1, high, k);
    } else {
        return rBsearch(L, low, mid - 1, k);
    }
 }