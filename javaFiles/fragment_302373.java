swap(a[out], a[smaller]);  // Called with element `a[out]`

private void swap (int one, int two) {

    int temp=a[one];    // This is equivalent to a[a[out]]
    a[one]=a[two];
    a[two]=temp;
}