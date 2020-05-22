static void mergeSort(int a[], int l, int u) {
    if(l+1 < u) {
        int mid = (l+u)/2;
        mergeSort(a,l,u); // this call is most likely unwanted
        mergeSort(a,mid,u);
        merge(a,l,mid,u);
    }
}