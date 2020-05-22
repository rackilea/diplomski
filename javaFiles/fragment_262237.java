static void rotation(int[] arr)
{
    int temp = arr[arr.length - 1];
    System.arraycopy(arr, 0, arr, 1, arr.length - 1);
    arr[0] = temp;
}