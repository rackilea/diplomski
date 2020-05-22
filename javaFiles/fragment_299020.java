private static int[] copy(int[] a, int index)
{
    index = index < a.length ? index : a.length;
    int b[] = new int[index];
    for(int i = 0; i < index; i++)
        b[i] = a[i];
    return b;
}