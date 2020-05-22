public static int[] greater(int[] a, int val)
{
    int[] greater = new int[a.length];
    int greaterNumber = 0;

    for (int i = 0; i < greater.length; i++)
        if (a[i] > val)
            greater[greaterNumber++] = a[i];

    return Arrays.copyOf(greater, greaterNumber);
}