public static double[] reverse (double[] a, int start, int end) {
    if (start >= end) {
        return a;
    }
    else {
        // this code will swap two elements
        double temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }
    return reverse (a, start+1, end-1);
}