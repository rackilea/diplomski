static int[] CloneArray(int[] arr)
{
    int[] ret = new int[arr.Length];
    for (int i = 0; i < arr.Length; ++i) ret[i] = arr[i];
    return ret;
}