private static int[] merge(int[] a, int[] b)
{
    int[] c = new int[a.length + b.length];
    int counterA = 0;
    int counterB = 0;
    int counterC = 0;

    while (counterA != a.length && counterB != b.length)
    {
        if (a[counterA] <= b[counterB])
            c[counterC++] = a[counterA++];
        else
            c[counterC++] = b[counterB++];
    }

    while (counterA != a.length)
        c[counterC++] = a[counterA++];

    while (counterB != b.length)
        c[counterC++] = b[counterB++];

    return c;
}

public static int[] mergeSort(int[] arr)
{ 
    if (arr.length < 2)
        return arr;

    int[] arr1 = new int[arr.length / 2];
    int[] arr2 = new int[arr.length - arr1.length];

    for (int i = 0; i < arr1.length; i++)
        arr1[i] = arr[i];

    for (int i = 0; i < arr2.length; i++)
        arr2[i] = arr[i + arr1.length];

    arr1 = mergeSort(arr1);
    arr2 = mergeSort(arr2);

    return merge(arr1, arr2);
}