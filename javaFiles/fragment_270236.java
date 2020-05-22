public static int[] resize(int[] arr)
{
    int len = arr.length;
    int[] copy = new int[len+1];
    for (int i = 0; i < len; i++)
    {
        copy[i] = arr[i];
    }
    return copy;
}