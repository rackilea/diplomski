private static void swap(double[] a, int i, int j) {
    double t = a[i];
    a[i] = a[j];
    a[j] = t;
}

private static int partition(double [] a, int left,int right,int pivotIndex)
{
    swap(a, pivotIndex, right);
    int pos = left;//represents boundary between small and large elements
    for(int i = left; i < right; i++)
    {
        if (a[i] < a[right])
        {
            swap(a, i, pos);
            pos++;
        }
    }
    swap(a, right, pos);
    return pos;
}